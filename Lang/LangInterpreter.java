package Lang;

import grammar.*;
import java.util.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ParseTree;

public class LangInterpreter extends LangBaseVisitor<Object> {

    // --- ESTRUTURAS ---
    private static class TaggedUnion {
        Map<String, Object> data = new HashMap<>();
        String activeTag = null; 
        void set(String field, Object value) { data.put(field, value); activeTag = field; }
        Object get(String field) {
            if (activeTag == null) throw new RuntimeException("Union não inicializada.");
            // Apenas avisa, não bloqueia (para fins de teste)
            if (!activeTag.equals(field)) System.out.println("[AVISO] Union: Campo ativo é '" + activeTag + "', lendo '" + field + "'.");
            return data.get(field);
        }
    }

    private static class ActivationRecord {
        String funcName;
        Map<String, Object> variables = new HashMap<>();
        Map<String, String> pointers = new HashMap<>(); 
        public ActivationRecord(String name) { this.funcName = name; }
    }

    private Stack<ActivationRecord> callStack = new Stack<>();
    private Map<String, LangParser.FunctionContext> functions = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    
    // Controle de Fluxo
    private boolean returnFlag = false;
    private Object returnValue = null;

    public LangInterpreter() { callStack.push(new ActivationRecord("global")); }
    public void cleanup() { scanner.close(); }

    // --- HELPERS ---
    private int asInt(Object o) {
        if (o == null) return 0;
        if (o instanceof Integer) return (Integer) o;
        if (o instanceof Double) return ((Double) o).intValue();
        if (o instanceof Boolean) return ((Boolean) o) ? 1 : 0;
        // Tenta converter String numérica, se falhar (ex: nome de variavel), retorna 0
        try { return Integer.parseInt(o.toString()); } catch (Exception e) { return 0; }
    }

    private int myAtoi(String str) {
        if (str == null) return 0;
        str = str.replace("\"", "").trim();
        if (str.isEmpty()) return 0;
        int sign = 1, i = 0;
        if (str.charAt(0) == '-') { sign = -1; i++; } else if (str.charAt(0) == '+') { i++; }
        long result = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            result = result * 10 + (str.charAt(i) - '0');
            if (sign == 1 && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int) (result * sign);
    }
    
    private Object getVar(String name) {
        // Busca na pilha (Escopo Dinâmico)
        for (int i = callStack.size() - 1; i >= 0; i--) {
            ActivationRecord ar = callStack.get(i);
            if (ar.variables.containsKey(name)) return ar.variables.get(name);
            if (ar.pointers.containsKey(name)) return ar.pointers.get(name);
        }
        throw new RuntimeException("Variável '" + name + "' não encontrada.");
    }

    private void setVar(String name, Object value) {
        for (int i = callStack.size() - 1; i >= 0; i--) {
            ActivationRecord ar = callStack.get(i);
            if (ar.variables.containsKey(name)) { ar.variables.put(name, value); return; }
            if (ar.pointers.containsKey(name)) { ar.pointers.put(name, value != null ? value.toString() : null); return; }
        }
        callStack.peek().variables.put(name, value);
    }

    // --- NAVEGAÇÃO ---
    @Override 
    public Object visitProg(LangParser.ProgContext ctx) {
        if (ctx.children != null) for (ParseTree c : ctx.children) visit(c);
        return null;
    }
    @Override public Object visitDeclaration(LangParser.DeclarationContext ctx) { return visit(ctx.getChild(0)); }
    @Override public Object visitFunction(LangParser.FunctionContext ctx) {
        String name = ctx.VAR() != null ? ctx.VAR().getText() : "main";
        functions.put(name, ctx);
        return null;
    }

    public void executeProgram() {
        if (functions.containsKey("main")) executeFunction("main", new ArrayList<>());
        else throw new RuntimeException("main() não encontrada.");
    }

    private Object executeFunction(String name, List<Object> args) {
        LangParser.FunctionContext ctx = functions.get(name);
        ActivationRecord ar = new ActivationRecord(name);
        if (ctx.params() != null) {
            int childIndex = 0;
            int argIndex = 0;
            while(childIndex < ctx.params().getChildCount() && argIndex < args.size()) {
                childIndex++; 
                boolean isPtr = false;
                if (ctx.params().getChild(childIndex).getText().equals("*")) { isPtr = true; childIndex++; }
                String pName = ctx.params().getChild(childIndex).getText();
                childIndex++;
                if (isPtr) ar.pointers.put(pName, args.get(argIndex).toString());
                else ar.variables.put(pName, args.get(argIndex));
                if (childIndex < ctx.params().getChildCount()) childIndex++;
                argIndex++;
            }
        }
        callStack.push(ar);
        visit(ctx.fnBlock());
        Object res = returnValue;
        returnFlag = false; returnValue = null;
        callStack.pop();
        return (res == null) ? 0 : res;
    }

    @Override public Object visitFuncinvoc(LangParser.FuncinvocContext ctx) {
        String name = ctx.VAR().getText();
        List<Object> args = new ArrayList<>();
        if (ctx.argumentos() != null) for (var e : ctx.argumentos().expression()) args.add(visit(e));
        if (name.equals("atoi")) return args.isEmpty() ? 0 : myAtoi(args.get(0).toString());
        return executeFunction(name, args);
    }

    // --- CORREÇÃO CRÍTICA: PRESERVA TIPOS EM EXPRESSÕES ---
    @Override public Object visitExpression(LangParser.ExpressionContext ctx) {
        if (ctx.term() != null) {
            Object res = visit(ctx.term());
            // Se não tem cauda (+, -), retorna o objeto original (String, Struct, etc)
            // ISSO IMPEDE QUE O PONTEIRO VIRE ZERO
            if (ctx.termTail().isEmpty()) return res;
            
            // Se tem cauda, é matemática -> converte para int
            int val = asInt(res);
            for (var t : ctx.termTail()) {
                int next = asInt(visit(t.term()));
                if (t.getStart().getText().equals("+")) val += next; else val -= next;
            }
            return val;
        }
        return null;
    }

    @Override public Object visitTerm(LangParser.TermContext ctx) {
        Object res = visit(ctx.factor());
        // Mesma lógica: se não tem * ou /, retorna original
        if (ctx.factorTail().isEmpty()) return res;

        int val = asInt(res);
        for (var f : ctx.factorTail()) {
            int next = asInt(visit(f.factor()));
            String op = f.getStart().getText();
            if (op.equals("*")) val *= next; else if (op.equals("/")) val /= next; else val %= next;
        }
        return val;
    }
    // -------------------------------------------------------

    @Override public Object visitFactor(LangParser.FactorContext ctx) {
        if (ctx.NUM() != null) return Integer.parseInt(ctx.NUM().getText());
        if (ctx.DECIM() != null) return Double.parseDouble(ctx.DECIM().getText());
        if (ctx.FORMATSTRING() != null) return ctx.FORMATSTRING().getText().replace("\"", ""); // Remove aspas
        
        if (ctx.funcinvoc() != null) return visit(ctx.funcinvoc());
        
        // &var retorna o NOME (String)
        if (ctx.getText().startsWith("&")) return ctx.VAR().getText();
        
        // *p retorna o VALOR da variável apontada
        if (ctx.getText().startsWith("*")) { 
            String ptr = ctx.VAR().getText();
            // O valor de ptr deve ser o nome da variável alvo (ex: "valor")
            Object targetObj = getVar(ptr); 
            if (targetObj == null) throw new RuntimeException("Ponteiro '" + ptr + "' é nulo.");
            return getVar(targetObj.toString());
        }

        if (ctx.getText().contains("[") && ctx.VAR() != null) {
            List<Object> array = (List<Object>) getVar(ctx.VAR().getText());
            int index = asInt(visit(ctx.expression()));
            return array.get(index);
        }
        
        if (ctx.VAR() != null) return getVar(ctx.VAR().getText());
        if (ctx.expression() != null) return visit(ctx.expression());
        if (ctx.structaccess() != null) return visit(ctx.structaccess());
        if (ctx.unionaccess() != null) return visit(ctx.unionaccess());
        return 0;
    }

    @Override public Object visitAtrib(LangParser.AtribContext ctx) {
        String varName = ctx.VAR().getText();
        
        // *p = ...
        if (ctx.getText().startsWith("*")) {
            String ptrName = ctx.VAR().getText();
            Object targetObj = getVar(ptrName);
            if (targetObj == null) throw new RuntimeException("Ponteiro inválido: " + ptrName);
            Object val = visit(ctx.expression(0));
            setVar(targetObj.toString(), val);
            return null;
        }
        
        // arr[0] = ...
        if (ctx.getText().contains("[") && ctx.getText().contains("]")) {
            List<Object> array = (List<Object>) getVar(varName);
            int index = asInt(visit(ctx.expression(0)));
            Object value = visit(ctx.expression(1));
            array.set(index, value);
            return null;
        }

        if (ctx.typeSpec() != null) { 
            Object val = null;
            if (!ctx.expression().isEmpty()) val = visit(ctx.expression(0));
            else if (ctx.funcinvoc() != null) val = visit(ctx.funcinvoc());
            callStack.peek().variables.put(varName, val);
        } else {
            if (ctx.AT() != null) {
                Object val = (!ctx.expression().isEmpty()) ? visit(ctx.expression(0)) : visit(ctx.funcinvoc());
                setVar(varName, val);
            } else { 
                int v = asInt(getVar(varName));
                if (ctx.getText().contains("++")) v++;
                else if (ctx.getText().contains("--")) v--;
                else if (ctx.getText().contains("+=")) v += asInt(visit(ctx.expression(0)));
                else if (ctx.getText().contains("-=")) v -= asInt(visit(ctx.expression(0)));
                setVar(varName, v);
            }
        }
        return null;
    }

    // --- RESTO ---
    @Override public Object visitGlobalVariable(LangParser.GlobalVariableContext ctx) { 
        if(ctx.DEFINE() != null) {
             Object val = (ctx.expression() != null) ? visit(ctx.expression()) : null;
             callStack.firstElement().variables.put(ctx.VAR().getText(), val);
        }
        return null; 
    }
    @Override public Object visitFnBodyItem(LangParser.FnBodyItemContext ctx) { 
        if(ctx.RETURN()!=null){
            returnFlag=true; 
            returnValue=(ctx.expression() != null) ? visit(ctx.expression()) : null;
        } else { visit(ctx.line()); }
        return null; 
    }
    @Override public Object visitArraydecl(LangParser.ArraydeclContext ctx) {
        String name = ctx.VAR().getText();
        int size = Integer.parseInt(ctx.NUM().getText());
        List<Object> array = new ArrayList<>(Collections.nCopies(size, null));
        if(ctx.arrayelems() != null) {
            var exprs = ctx.arrayelems().expression();
            for(int i=0; i<Math.min(size, exprs.size()); i++) array.set(i, visit(exprs.get(i)));
        }
        callStack.peek().variables.put(name, array);
        return null;
    }
    @Override public Object visitPointerdecl(LangParser.PointerdeclContext ctx) {
        callStack.peek().pointers.put(ctx.VAR().getText(), null); return null;
    }
    @Override public Object visitPointerassign(LangParser.PointerassignContext ctx) {
        String ptr = ctx.VAR(0).getText();
        String target = ctx.VAR(1).getText();
        getVar(target); setVar(ptr, target); return null;
    }
    @Override public Object visitPointerdereference(LangParser.PointerdereferenceContext ctx) {
        // Lógica tratada no visitAtrib (starts with *)
        return null;
    }
    @Override public Object visitStructdeclaration(LangParser.StructdeclarationContext ctx) {
        callStack.peek().variables.put(ctx.VAR(1).getText(), new HashMap<String, Object>()); return null;
    }
    @Override @SuppressWarnings("unchecked")
    public Object visitStructaccess(LangParser.StructaccessContext ctx) {
        String name = ctx.VAR(0).getText();
        String field = ctx.VAR(1).getText();
        Object obj = getVar(name);
        if (obj instanceof TaggedUnion) {
            TaggedUnion u = (TaggedUnion) obj;
            if (ctx.AT() != null) { u.set(field, visit(ctx.expression())); return null; }
            return u.get(field);
        }
        Map<String, Object> s = (Map<String, Object>) obj;
        if (ctx.AT() != null) { s.put(field, visit(ctx.expression())); return null; }
        return s.get(field);
    }
    @Override public Object visitUniondeclaration(LangParser.UniondeclarationContext ctx) {
        callStack.peek().variables.put(ctx.VAR(1).getText(), new TaggedUnion()); return null;
    }
    @Override public Object visitUnionaccess(LangParser.UnionaccessContext ctx) {
        return visitStructaccess(new LangParser.StructaccessContext(ctx.getParent(), ctx.invokingState));
    }
    @Override public Object visitOutput(LangParser.OutputContext ctx) {
        if (ctx.PRINT() != null) {
            String fmt = ctx.FORMATSTRING().getText().replace("\"", "");
            List<Object> args = new ArrayList<>();
            if(!ctx.expression().isEmpty()) for (var e : ctx.expression()) args.add(visit(e));
            System.out.printf(fmt + "\n", args.toArray());
        } else if (ctx.PUTS() != null) { System.out.println(getVar(ctx.VAR().getText())); }
        return null;
    }
    @Override public Object visitInput(LangParser.InputContext ctx) {
        if (ctx.SCAN() != null) {
            for (var v : ctx.VAR()) {
                System.out.print("> ");
                if (scanner.hasNextInt()) setVar(v.getText(), scanner.nextInt());
                else setVar(v.getText(), scanner.next());
            }
        } else if(ctx.GETS()!=null) setVar(ctx.VAR(0).getText(), scanner.next());
        return null;
    }
    private boolean isTrue(Object o) { if (o instanceof Integer) return (Integer)o != 0; if (o instanceof Boolean) return (Boolean)o; return false; }
    @Override public Object visitIfstmt(LangParser.IfstmtContext ctx) { if(isTrue(visit(ctx.cond()))) visit(ctx.fnBlock(0)); else if(ctx.ELSE()!=null) visit(ctx.fnBlock(1)); return null; }
    @Override public Object visitWhilestmt(LangParser.WhilestmtContext ctx) { while(isTrue(visit(ctx.cond()))){visit(ctx.fnBlock()); if(returnFlag) break;} return null; }
    @Override public Object visitForstmt(LangParser.ForstmtContext ctx) { visit(ctx.atrib(0)); while(isTrue(visit(ctx.cond()))){visit(ctx.fnBlock()); if(returnFlag) break; visit(ctx.atrib(1));} return null; }
    @Override public Object visitCond(LangParser.CondContext ctx) {
        if (ctx.RELOP() != null) {
            int v1 = asInt(visit(ctx.cond(0)!=null?ctx.cond(0):ctx.expression()));
            int v2 = asInt(visit(ctx.cond(1)));
            String op = ctx.RELOP().getText();
            if(op.equals(">")) return v1>v2; if(op.equals("<")) return v1<v2; if(op.equals("==")) return v1==v2; if(op.equals("!=")) return v1!=v2;
            if(op.equals(">=")) return v1>=v2; if(op.equals("<=")) return v1<=v2;
        }
        if(ctx.expression() != null) return visit(ctx.expression());
        return false;
    }
    @Override public Object visitFnBodyList(LangParser.FnBodyListContext ctx) { for(var i:ctx.fnBodyItem()){visit(i); if(returnFlag) break;} return null; }
    @Override public Object visitLine(LangParser.LineContext ctx) { if(ctx.stmt()!=null) visit(ctx.stmt()); else if(ctx.ifstmt()!=null) visit(ctx.ifstmt()); else if(ctx.whilestmt()!=null) visit(ctx.whilestmt()); else if(ctx.dowhilestmt()!=null) visit(ctx.dowhilestmt()); else if(ctx.forstmt()!=null) visit(ctx.forstmt()); else if(ctx.switchstmt()!=null) visit(ctx.switchstmt()); else if(ctx.fnBlock()!=null) visit(ctx.fnBlock()); return null; }
    @Override public Object visitStmt(LangParser.StmtContext ctx) { if(ctx.atrib()!=null) visit(ctx.atrib()); else if(ctx.output()!=null) visit(ctx.output()); else if(ctx.input()!=null) visit(ctx.input()); else if(ctx.arraydecl()!=null) visit(ctx.arraydecl()); else if(ctx.pointerdecl()!=null) visit(ctx.pointerdecl()); else if(ctx.pointerassign()!=null) visit(ctx.pointerassign()); else if(ctx.pointerdereference()!=null) visit(ctx.pointerdereference()); else if(ctx.structdeclaration()!=null) visit(ctx.structdeclaration()); else if(ctx.structaccess()!=null) visit(ctx.structaccess()); else if(ctx.uniondeclaration()!=null) visit(ctx.uniondeclaration()); else if(ctx.unionaccess()!=null) visit(ctx.unionaccess()); else if(ctx.funcinvoc()!=null) visit(ctx.funcinvoc()); return null; }
    @Override public Object visitSwitchstmt(LangParser.SwitchstmtContext ctx) { return null; } 
    @Override public Object visitDowhilestmt(LangParser.DowhilestmtContext ctx) { return null; }
}