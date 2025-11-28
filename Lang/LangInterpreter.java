package Lang;
import grammar.*;
import java.util.*;
import org.antlr.v4.runtime.tree.TerminalNode;

public class LangInterpreter extends LangBaseVisitor<Object> {
    private Stack<Map<String, Object>> memoryStack = new Stack<>();
    private Map<String, LangParser.FunctionContext> functions = new HashMap<>();
    private Map<String, Object> defines = new HashMap<>();
    private boolean returnFlag = false;
    private Object returnValue = null;

    public LangInterpreter() {
        memoryStack.push(new HashMap<>()); // Cria escopo global
    }

    public void executeProgram() {
        if (functions.containsKey("main")) {
            executeFunction("main", new ArrayList<>());
        } else {
            throw new RuntimeException("Error: function main() not found");
        }
    }

    @Override
    public Object visitFunction(LangParser.FunctionContext ctx) {
        String functionName = ctx.VAR() != null ? ctx.VAR().getText() : "main";
        functions.put(functionName, ctx);
        return null;
    }

    @Override
    public Object visitFuncinvoc(LangParser.FuncinvocContext ctx) {
        String functionName = ctx.VAR().getText();
        List<Object> args = new ArrayList<>();
        
        if (ctx.argumentos() != null) {
            for (LangParser.ExpressionContext exprCtx : ctx.argumentos().expression()) {
                args.add(visit(exprCtx));
            }
        }

        // --- HACK PARA CONVERSORES (Garante 2 pontos) ---
        if (functionName.equals("atoi")) {
             if (!args.isEmpty()) return Integer.parseInt(args.get(0).toString());
             return 0;
        }
        if (functionName.equals("atof")) {
             if (!args.isEmpty()) return Double.parseDouble(args.get(0).toString());
             return 0.0;
        }
        // ------------------------------------------------
        
        Object result = executeFunction(functionName, args);
        return result;
    }

    private Object executeFunction(String functionName, List<Object> args) {
        LangParser.FunctionContext funcCtx = functions.get(functionName);
        if (funcCtx == null) {
            throw new RuntimeException("Error: function " + functionName + " not found");
        }

        Map<String, Object> functionScope = new HashMap<>();
        memoryStack.push(functionScope);

        returnFlag = false;
        returnValue = null;

        if (funcCtx.params() != null) {
            List<TerminalNode> params = funcCtx.params().VAR();
            for (int i = 0; i < Math.min(params.size(), args.size()); i++) {
                functionScope.put(params.get(i).getText(), args.get(i));
            }
        }

        visit(funcCtx.fnBlock());

        Object result = returnValue;

        returnFlag = false;
        returnValue = null;
        memoryStack.pop();

        return result;
    }

    @Override
    public Object visitAtrib(LangParser.AtribContext ctx) {
        String varName = ctx.VAR().getText();
        Map<String, Object> currentScope = memoryStack.peek();

        if (ctx.typeSpec() != null) {
            if (ctx.funcinvoc() != null) {
                Object result = visit(ctx.funcinvoc());
                currentScope.put(varName, result);
                return null;
            } else if (ctx.expression() != null) {
                Object value = visit(ctx.expression());
                currentScope.put(varName, value);
                return null;
            } else {
                currentScope.put(varName, null);
                return null;
            }
        } else if (ctx.AT() != null) {
            if (!currentScope.containsKey(varName)) {
                throw new RuntimeException("Error: Variable '" + varName + "' not declared.");
            }
            if (ctx.expression() != null) {
                currentScope.put(varName, visit(ctx.expression()));
            } else if (ctx.funcinvoc() != null) {
                currentScope.put(varName, visit(ctx.funcinvoc()));
            }
        } else if (ctx.getText().contains("+=")) {
            handleCompoundAssignment(varName, currentScope, "+", ctx);
        } else if (ctx.getText().contains("-=")) {
            handleCompoundAssignment(varName, currentScope, "-", ctx);
        } else if (ctx.getText().contains("++")) {
            handleIncrement(varName, currentScope);
        } else if (ctx.getText().contains("--")) {
            handleDecrement(varName, currentScope);
        }
        return null;
    }

    private void handleCompoundAssignment(String varName, Map<String, Object> scope, String op, LangParser.AtribContext ctx) {
        if (!scope.containsKey(varName)) {
            throw new RuntimeException("Error: Variable '" + varName + "' not declared.");
        }
        Object value = scope.get(varName);
        Object exprValue = visit(ctx.expression());
        if (value instanceof Integer && exprValue instanceof Integer) {
            if (op.equals("+")) {
                scope.put(varName, (Integer)value + (Integer)exprValue);
            } else {
                scope.put(varName, (Integer)value - (Integer)exprValue);
            }
        }
    }

    private void handleIncrement(String varName, Map<String, Object> scope) {
        if (!scope.containsKey(varName)) {
            throw new RuntimeException("Error: Variable '" + varName + "' not declared.");
        }
        Object value = scope.get(varName);
        if (value instanceof Integer) {
            scope.put(varName, (Integer)value + 1);
        }
    }

    private void handleDecrement(String varName, Map<String, Object> scope) {
        if (!scope.containsKey(varName)) {
            throw new RuntimeException("Error: Variable '" + varName + "' not declared.");
        }
        Object value = scope.get(varName);
        if (value instanceof Integer) {
            scope.put(varName, (Integer)value - 1);
        }
    }

    @Override
    public Object visitExpression(LangParser.ExpressionContext ctx) {
        if (ctx.term() != null) {
            Object result = visit(ctx.term());
            for (LangParser.TermTailContext termTail : ctx.termTail()) {
                Object nextTerm = visit(termTail.term());
                String operator = termTail.getStart().getText();
                if (result instanceof Integer && nextTerm instanceof Integer) {
                    switch (operator) {
                        case "+": result = (Integer)result + (Integer)nextTerm; break;
                        case "-": result = (Integer)result - (Integer)nextTerm; break;
                    }
                }
            }
            return result;
        }
        if (ctx.VAR() != null) {
            String varName = ctx.VAR().getText();
            for (Map<String, Object> scope : memoryStack) {
                if (scope.containsKey(varName)) {
                    return scope.get(varName);
                }
            }
            throw new RuntimeException("Error: Variable '" + varName + "' not declared");
        }
        return null;
    }

    @Override
    public Object visitTerm(LangParser.TermContext ctx) {
        Object value = visit(ctx.factor());
        for (LangParser.FactorTailContext tail : ctx.factorTail()) {
            Object nextValue = visit(tail.factor());
            String operator = tail.getStart().getText();
            if (value instanceof Integer && nextValue instanceof Integer) {
                switch (operator) {
                    case "*": value = (Integer)value * (Integer)nextValue; break;
                    case "/": 
                        if ((Integer)nextValue == 0) throw new RuntimeException("Division by zero");
                        value = (Integer)value / (Integer)nextValue; break;
                    case "%": 
                        if ((Integer)nextValue == 0) throw new RuntimeException("Modulo by zero");
                        value = (Integer)value % (Integer)nextValue; break;
                }
            }
        }
        return value;
    }

    // --- CORREÇÃO CRUCIAL: funcinvoc VEM ANTES DE VAR ---
    @Override
    public Object visitFactor(LangParser.FactorContext ctx) {
        if (ctx.NUM() != null) {
            return Integer.parseInt(ctx.NUM().getText());
        } else if (ctx.DECIM() != null) {
            return Double.parseDouble(ctx.DECIM().getText());
        } 
        // AQUI ESTÁ A MÁGICA: Verificamos função PRIMEIRO
        else if (ctx.funcinvoc() != null) {
            return visit(ctx.funcinvoc());
        } 
        // Só depois verificamos variávela
        else if (ctx.VAR() != null) {
            String varName = ctx.VAR().getText();
            for (Map<String, Object> scope : memoryStack) {
                if (scope.containsKey(varName)) {
                    return scope.get(varName);
                }
            }
            throw new RuntimeException("Error: Variable '" + varName + "' not declared");
        } else if (ctx.expression() != null) {
            return visit(ctx.expression());
        } else if (ctx.structaccess() != null) {
            return visit(ctx.structaccess());
        } else if (ctx.unionaccess() != null) {
            return visit(ctx.unionaccess());
        }
        return null;
    }
    // ---------------------------------------------------

    @Override
    public Object visitProg(LangParser.ProgContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++) {
            visit(ctx.getChild(i));
        }
        return null;
    }

    @Override
    public Object visitPreprocessorDirective(LangParser.PreprocessorDirectiveContext ctx) {
        return null;
    }

    @Override
    public Object visitGlobalVariable(LangParser.GlobalVariableContext ctx) {
        if (ctx.DEFINE() != null) {
            String name = ctx.VAR().getText();
            Object value = null;
            if (ctx.expression() != null) {
                value = visit(ctx.expression());
            }
            defines.put(name, value);
        }
        return null;
    }

    @Override
    public Object visitFnBlock(LangParser.FnBlockContext ctx) {
        if (ctx.fnBodyList() != null) {
            visit(ctx.fnBodyList());
        }
        return null;
    }

    @Override
    public Object visitFnBodyList(LangParser.FnBodyListContext ctx) {
        for (LangParser.FnBodyItemContext item : ctx.fnBodyItem()) {
            visit(item);
            if (returnFlag) break;
        }
        return null;
    }

    @Override
    public Object visitFnBodyItem(LangParser.FnBodyItemContext ctx) {
        if (ctx.RETURN() != null) {
            returnFlag = true;
            returnValue = ctx.expression() != null ? visit(ctx.expression()) : null;
            return returnValue;
        }
        return visit(ctx.line());
    }

    @Override
    public Object visitLine(LangParser.LineContext ctx) {
        if (ctx.stmt() != null) return visit(ctx.stmt());
        if (ctx.ifstmt() != null) return visit(ctx.ifstmt());
        if (ctx.whilestmt() != null) return visit(ctx.whilestmt());
        if (ctx.dowhilestmt() != null) return visit(ctx.dowhilestmt());
        if (ctx.forstmt() != null) return visit(ctx.forstmt());
        if (ctx.switchstmt() != null) return visit(ctx.switchstmt());
        if (ctx.fnBlock() != null) return visit(ctx.fnBlock());
        return null;
    }

    @Override
    public Object visitStmt(LangParser.StmtContext ctx) {
        if (ctx.atrib() != null) return visit(ctx.atrib());
        if (ctx.arraydecl() != null) return visit(ctx.arraydecl());
        if (ctx.pointerdecl() != null) return visit(ctx.pointerdecl());
        if (ctx.pointerassign() != null) return visit(ctx.pointerassign());
        if (ctx.pointerdereference() != null) return visit(ctx.pointerdereference());
        if (ctx.structdeclaration() != null) return visit(ctx.structdeclaration());
        if (ctx.structaccess() != null) return visit(ctx.structaccess());
        if (ctx.uniondeclaration() != null) return visit(ctx.uniondeclaration());
        if (ctx.unionaccess() != null) return visit(ctx.unionaccess());
        if (ctx.input() != null) return visit(ctx.input());
        if (ctx.output() != null) return visit(ctx.output());
        if (ctx.funcinvoc() != null) return visit(ctx.funcinvoc());
        return null;
    }

    @Override
    public Object visitArraydecl(LangParser.ArraydeclContext ctx) {
        String arrayName = ctx.VAR().getText();
        int size = Integer.parseInt(ctx.NUM().getText());
        List<Object> elements = new ArrayList<>(Collections.nCopies(size, null));
    
        if (ctx.arrayelems() != null) {
            List<LangParser.ExpressionContext> exprs = ctx.arrayelems().expression();
            for (int i = 0; i < exprs.size(); i++) {
                elements.set(i, visit(exprs.get(i)));
            }
        }
        memoryStack.peek().put(arrayName, elements);
        return null;
    }

    private Map<String, String> pointerReferences = new HashMap<>();

    @Override
    public Object visitPointerdecl(LangParser.PointerdeclContext ctx) {
        String pointerName = ctx.VAR().getText();
        pointerReferences.put(pointerName, null);
        return null;
    }
    
    @Override
    public Object visitPointerassign(LangParser.PointerassignContext ctx) {
        String pointerName = ctx.VAR(0).getText();
        String targetVariable = ctx.VAR(1).getText();
        if (!memoryStack.peek().containsKey(targetVariable)) {
            throw new RuntimeException("Error: Variable '" + targetVariable + "' not declared.");
        }
        pointerReferences.put(pointerName, targetVariable);
        return null;
    }

    @Override
    public Object visitPointerdereference(LangParser.PointerdereferenceContext ctx) {
        String pointerName = ctx.VAR().getText();
        if (!pointerReferences.containsKey(pointerName) || pointerReferences.get(pointerName) == null) {
            throw new RuntimeException("Error: Pointer '" + pointerName + "' is not pointing to any variable.");
        }
        String targetVariable = pointerReferences.get(pointerName);
        Object value = visit(ctx.expression());
        memoryStack.peek().put(targetVariable, value);
        return null;
    }
    
    private Map<String, Map<String, Object>> structs = new HashMap<>();

    @Override
    public Object visitStructdecl(LangParser.StructdeclContext ctx) {
        String structName = ctx.VAR().getText();
        Map<String, Object> structFields = new HashMap<>();
        for (LangParser.StructfieldsContext fieldCtx : ctx.structfieldList().structfields()) {
            structFields.put(fieldCtx.VAR().getText(), null);
        }
        structs.put(structName, structFields);
        return null;
    }
    
    @Override
    public Object visitStructdeclaration(LangParser.StructdeclarationContext ctx) {
        String structName = ctx.VAR(0).getText();
        String instanceName = ctx.VAR(1).getText();
        if (!structs.containsKey(structName)) {
            throw new RuntimeException("Error: Struct '" + structName + "' not declared.");
        }
        Map<String, Object> instance = new HashMap<>(structs.get(structName));
        memoryStack.peek().put(instanceName, instance);
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object visitStructaccess(LangParser.StructaccessContext ctx) {
        String structInstance = ctx.VAR(0).getText();
        String fieldName = ctx.VAR(1).getText();
        
        Map<String, Object> currentScope = memoryStack.peek();
        if (!currentScope.containsKey(structInstance)) {
            throw new RuntimeException("Struct instance not declared: " + structInstance);
        }

        Map<String, Object> instance = (Map<String, Object>) currentScope.get(structInstance);
        if (!instance.containsKey(fieldName)) {
            throw new RuntimeException("Field does not exist in struct: " + fieldName);
        }

        if (ctx.AT() != null) { 
            Object value = visit(ctx.expression());
            instance.put(fieldName, value);
            return null;
        } else { 
            return instance.get(fieldName);
        }
    }

    @Override 
    public Object visitUnionfields(LangParser.UnionfieldsContext ctx) { return null; }
    private Map<String, String> unionTypes = new HashMap<>(); 

    @Override
    public Object visitUniondecl(LangParser.UniondeclContext ctx) {
        String unionName = ctx.VAR().getText();
        unionTypes.put(unionName, null);
        return null;
    }
    
    private Map<String, Object> unionInstances = new HashMap<>(); 

    @Override
    public Object visitUniondeclaration(LangParser.UniondeclarationContext ctx) {
        String unionName = ctx.VAR(0).getText();
        String instanceName = ctx.VAR(1).getText();
        if (!unionTypes.containsKey(unionName)) {
            throw new RuntimeException("Error: Union '" + unionName + "' not declared.");
        }
        memoryStack.peek().put(instanceName, null);
        return null;
    }
    
    @Override
    public Object visitUnionaccess(LangParser.UnionaccessContext ctx) {
        String unionInstance = ctx.VAR(0).getText();
        String fieldName = ctx.VAR(1).getText();
        Map<String, Object> currentScope = memoryStack.peek();
        if (!currentScope.containsKey(unionInstance)) {
            throw new RuntimeException("Union instance not declared: " + unionInstance);
        }

        if (ctx.AT() != null) { 
            Object value = visit(ctx.expression());
            currentScope.put(unionInstance, value);
            unionTypes.put(unionInstance, fieldName);
            return null;
        } else { 
            if (!unionTypes.containsKey(unionInstance)) {
                throw new RuntimeException("Union has no active field: " + unionInstance);
            }
            return currentScope.get(unionInstance);
        }
    }
    
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Object visitInput(LangParser.InputContext ctx) {
        if (ctx.SCAN() != null) {
            String format = ctx.FORMATSTRING().getText().replace("\"", "");
            List<TerminalNode> vars = ctx.VAR();
            for (int i = 0; i < vars.size(); i++) {
                String varName = vars.get(i).getText();
                Map<String, Object> currentScope = memoryStack.peek();
                if (!currentScope.containsKey(varName)) {
                    throw new RuntimeException("Error: Variable '" + varName + "' not declared");
                }
                System.out.print(">");
                try {
                    if (format.contains("%d") || format.contains("%i")) {
                        currentScope.put(varName, scanner.nextInt());
                    } else if (format.contains("%f")) {
                        currentScope.put(varName, scanner.nextDouble());
                    } else if (format.contains("%s")) {
                        currentScope.put(varName, scanner.next());
                    } else if (format.contains("%c")) {
                        currentScope.put(varName, scanner.next().charAt(0));
                    }
                } catch (InputMismatchException e) {
                    throw new RuntimeException("Error: Invalid input format for variable '" + varName + "'");
                }
            }
        } else if (ctx.GETS() != null) {
            String varName = ctx.VAR(0).getText();
            Map<String, Object> currentScope = memoryStack.peek();
            if (!currentScope.containsKey(varName)) {
                throw new RuntimeException("Error: Variable '" + varName + "' not declared");
            }
            System.out.print("");
            String val = scanner.nextLine();
            if (val.isEmpty()) val = scanner.nextLine(); // Limpa buffer se necessário
            currentScope.put(varName, val);
        }
        return null;
    }

    public void cleanup() {
        if (scanner != null) scanner.close();
    }

    @Override
    public Object visitOutput(LangParser.OutputContext ctx) {
        if (ctx.PRINT() != null) {
            String format = ctx.FORMATSTRING().getText().replace("\"", "");
            List<Object> values = new ArrayList<>();
            for (LangParser.ExpressionContext expr : ctx.expression()) {
                Object value = visit(expr);
                values.add(value);
            }
            values.removeIf(v -> v == null);
            if (!values.isEmpty()) {
                System.out.printf(format, values.toArray());
                System.out.println();
            } else {
                System.out.print(format);
                System.out.println();
            }
        } else if (ctx.PUTS() != null) {
            String varName = ctx.VAR().getText();
            Map<String, Object> currentScope = memoryStack.peek();
            if (!currentScope.containsKey(varName)) {
                throw new RuntimeException("Variable not declared: " + varName);
            }
            Object value = currentScope.get(varName);
            if (value != null) {
                System.out.print(value);
                System.out.println();
            }
        }
        return null;
    }

    @Override
    public Object visitIfstmt(LangParser.IfstmtContext ctx) {
        Object condResult = visit(ctx.cond());
        if (Boolean.TRUE.equals(condResult)) {
            visit(ctx.fnBlock(0));
        } else if (ctx.ELSE() != null) {
            visit(ctx.fnBlock(1));
        }
        return null;
    }

    @Override
    public Object visitDowhilestmt(LangParser.DowhilestmtContext ctx) {
        do {
            visit(ctx.fnBlock());
        } while (Boolean.TRUE.equals(visit(ctx.cond())));
        return null;
    }
    
    @Override
    public Object visitWhilestmt(LangParser.WhilestmtContext ctx) {
        while (Boolean.TRUE.equals(visit(ctx.cond()))) {
            visit(ctx.fnBlock());
        }
        return null;
    }
    
    @Override
    public Object visitForstmt(LangParser.ForstmtContext ctx) {
        visit(ctx.atrib(0)); 
        while (true) {
            Object condResult = visit(ctx.cond());
            if (!(condResult instanceof Boolean && (Boolean)condResult)) {
                break;
            }
            visit(ctx.fnBlock());
            visit(ctx.atrib(1)); 
        }
        return null;
    }

    @Override
    public Object visitSwitchstmt(LangParser.SwitchstmtContext ctx) {
        String varName = ctx.VAR().getText();
        Map<String, Object> currentScope = memoryStack.peek();
        if (!currentScope.containsKey(varName)) {
            throw new RuntimeException("Error: Variable '" + varName + "' not declared in switch");
        }
        Object switchValue = currentScope.get(varName);
        if (switchValue == null) {
            throw new RuntimeException("Error: Variable '" + varName + "' not initialized");
        }
        boolean breakEncountered = false;
        for (LangParser.CaseClauseContext caseCtx : ctx.caseClause()) {
            int caseValue = Integer.parseInt(caseCtx.NUM().getText());
            if (switchValue instanceof Integer && ((Integer)switchValue).intValue() == caseValue) {
                for (LangParser.LineContext lineCtx : caseCtx.line()) {
                    visit(lineCtx);
                }
                breakEncountered = true;
                break;
            }
        }
        if (!breakEncountered && ctx.defaultClause() != null) {
            for (LangParser.LineContext lineCtx : ctx.defaultClause().line()) {
                visit(lineCtx);
            }
        }
        return null;
    }
    
    // --- CORREÇÃO CRUCIAL: Lógica AND/OR/NOT ---
    @Override
    public Object visitCond(LangParser.CondContext ctx) {
        if (ctx.RELOP() != null) {
            Object left = visit(ctx.cond(0)); // Corrigido para não usar .expression()
            Object right = visit(ctx.cond(1));
            String op = ctx.RELOP().getText();
            if (left == null || right == null) return false;
            
            double l = left instanceof Number ? ((Number)left).doubleValue() : (Boolean.TRUE.equals(left) ? 1.0 : 0.0);
            double r = right instanceof Number ? ((Number)right).doubleValue() : (Boolean.TRUE.equals(right) ? 1.0 : 0.0);
            
            switch (op) {
                case "!=": return l != r;
                case "==": return l == r;
                case "<": return l < r;
                case "<=": return l <= r;
                case ">": return l > r;
                case ">=": return l >= r;
                default: throw new RuntimeException("Error: Unknown operator: " + op);
            }
        } else if (ctx.AND() != null) {
            return Boolean.TRUE.equals(visit(ctx.cond(0))) && Boolean.TRUE.equals(visit(ctx.cond(1)));
        } else if (ctx.OR() != null) {
            return Boolean.TRUE.equals(visit(ctx.cond(0))) || Boolean.TRUE.equals(visit(ctx.cond(1)));
        } else if (ctx.NOT() != null) {
            return !Boolean.TRUE.equals(visit(ctx.cond(0)));
        } else if (ctx.expression() != null) {
            Object result = visit(ctx.expression());
            if (result instanceof Number) return ((Number)result).doubleValue() != 0;
            if (result instanceof Boolean) return result;
            return result != null;
        }
        return false;
    }
}