package Lang;

import grammar.*;
import java.util.*;
import org.antlr.v4.runtime.tree.TerminalNode;

public class SemanticLangListener extends LangBaseListener {
    
    // Enum para Data Flow Analysis (DFA)
    public enum InitState { UNINIT, INIT }

    public final List<String> errors = new ArrayList<>();
    public final Map<String, Map<String, String>> declaredStructs = new HashMap<>();
    public final Map<String, Map<String, String>> declaredUnions = new HashMap<>();
    public final Map<String, LangParser.FunctionContext> declaredFunctions = new HashMap<>();
    public final Map<String, Object> defines = new HashMap<>();
    public final Set<String> includedLibs = new HashSet<>();
    
    public boolean hasMainFunction = false;
    
    // --- CLASSE DE SÍMBOLOS E ESCOPO ---
    private static class SymbolInfo {
        String type;
        InitState state;
        public SymbolInfo(String type, InitState state) {
            this.type = type;
            this.state = state;
        }
    }

    private class Scope {
        private final Map<String, SymbolInfo> symbols = new HashMap<>();
        private final Scope parent;
        
        public Scope(Scope parent) { this.parent = parent; }
        
        public void define(String name, String type, InitState state) {
            symbols.put(name, new SymbolInfo(type, state));
        }
        
        public SymbolInfo resolve(String name) {
            if (symbols.containsKey(name)) return symbols.get(name);
            return parent != null ? parent.resolve(name) : null;
        }
        
        public void initialize(String name) {
            if (symbols.containsKey(name)) symbols.get(name).state = InitState.INIT;
            else if (parent != null) parent.initialize(name);
        }
    }

    private Stack<Scope> scopeStack = new Stack<>();
    private Scope currentScope = new Scope(null);

    // --- MÉTODOS AUXILIARES ---
    public List<String> getErrors() { return errors; }
    public boolean hasErrors() { return !errors.isEmpty(); }

    private boolean isNumericType(String type) {
        return type != null && (type.equals("int") || type.equals("float") || type.equals("double") || type.equals("char"));
    }

    // Validação de scanf (Preenchida corretamente)
    private void validateScanfFormat(String format, List<TerminalNode> vars) {
        if (format.length() < 2) return;
        format = format.substring(1, format.length() - 1);
        int count = 0;
        for (int i = 0; i < format.length(); i++) {
            if (format.charAt(i) == '%') {
                if (i + 1 < format.length() && "dfsc".indexOf(format.charAt(i + 1)) >= 0) count++;
            }
        }
        if (count != vars.size()) errors.add("Erro: Quantidade de variáveis no scanf difere do formato.");
    }

    // Validação de printf (Preenchida corretamente)
    private void validatePrintfFormat(String format, List<LangParser.ExpressionContext> exprs) {
        if (format.length() < 2) return;
        format = format.substring(1, format.length() - 1);
        int count = 0;
        for (int i = 0; i < format.length(); i++) {
            if (format.charAt(i) == '%') {
                if (i + 1 < format.length() && "dfsc".indexOf(format.charAt(i + 1)) >= 0) count++;
            }
        }
        if (count != exprs.size()) errors.add("Erro: Quantidade de argumentos no printf difere do formato.");
    }

    // --- LISTENERS ---

    @Override public void enterFunction(LangParser.FunctionContext ctx) {
        String funcName = ctx.VAR() != null ? ctx.VAR().getText() : "main";
        if (funcName.equals("main")) hasMainFunction = true;
        if (declaredFunctions.containsKey(funcName)) errors.add("Função redeclarada: " + funcName);
        else declaredFunctions.put(funcName, ctx);

        Scope fnScope = new Scope(currentScope);
        scopeStack.push(currentScope);
        currentScope = fnScope;

        if (ctx.params() != null) {
            int childIndex = 0;
            while(childIndex < ctx.params().getChildCount()) {
                String type = ctx.params().getChild(childIndex).getText(); childIndex++;
                if (ctx.params().getChild(childIndex).getText().equals("*")) { type += "*"; childIndex++; }
                String name = ctx.params().getChild(childIndex).getText(); childIndex++;
                currentScope.define(name, type, InitState.INIT);
                if (childIndex < ctx.params().getChildCount()) childIndex++;
            }
        }
    }

    @Override public void exitFunction(LangParser.FunctionContext ctx) {
        if (!scopeStack.isEmpty()) currentScope = scopeStack.pop();
    }
    @Override public void enterFnBlock(LangParser.FnBlockContext ctx) {
        if (!(ctx.getParent() instanceof LangParser.FunctionContext)) {
            Scope blockScope = new Scope(currentScope);
            scopeStack.push(currentScope);
            currentScope = blockScope;
        }
    }
    @Override public void exitFnBlock(LangParser.FnBlockContext ctx) {
        if (!(ctx.getParent() instanceof LangParser.FunctionContext)) {
            if (!scopeStack.isEmpty()) currentScope = scopeStack.pop();
        }
    }

    // Declarações Globais e Tipos
    @Override public void exitGlobalVariable(LangParser.GlobalVariableContext ctx) {
        if (ctx.DEFINE() != null) defines.put(ctx.VAR().getText(), null);
    }
    @Override public void exitStructdecl(LangParser.StructdeclContext ctx) {
        String name = ctx.VAR().getText();
        Map<String, String> fields = new HashMap<>();
        if(ctx.structfieldList() != null) {
             for (var field : ctx.structfieldList().structfields()) fields.put(field.VAR().getText(), field.typeSpec().getText());
        }
        declaredStructs.put(name, fields);
    }
    @Override public void exitUniondecl(LangParser.UniondeclContext ctx) {
        String name = ctx.VAR().getText();
        Map<String, String> fields = new HashMap<>();
        if(ctx.unionfieldList() != null) {
             for (var field : ctx.unionfieldList().unionfields()) fields.put(field.VAR().getText(), field.typeSpec().getText());
        }
        declaredUnions.put(name, fields);
    }
    @Override public void exitStructdeclaration(LangParser.StructdeclarationContext ctx) {
        String type = ctx.VAR(0).getText();
        String name = ctx.VAR(1).getText();
        if (!declaredStructs.containsKey(type)) errors.add("Struct desconhecida: " + type);
        currentScope.define(name, "struct:" + type, InitState.INIT); 
    }
    @Override public void exitUniondeclaration(LangParser.UniondeclarationContext ctx) {
        String type = ctx.VAR(0).getText();
        String name = ctx.VAR(1).getText();
        if (!declaredUnions.containsKey(type)) errors.add("Union desconhecida: " + type);
        currentScope.define(name, "union:" + type, InitState.INIT);
    }

    // Arrays e Ponteiros
    @Override public void exitArraydecl(LangParser.ArraydeclContext ctx) {
        String name = ctx.VAR().getText();
        String type = ctx.typeSpec().getText();
        currentScope.define(name, type + "[]", InitState.INIT);
    }
    @Override public void exitPointerdecl(LangParser.PointerdeclContext ctx) {
        String name = ctx.VAR().getText();
        String type = ctx.typeSpec().getText();
        currentScope.define(name, type + "*", InitState.UNINIT);
    }
    @Override public void exitPointerassign(LangParser.PointerassignContext ctx) {
        String ptrName = ctx.VAR(0).getText();
        String varName = ctx.VAR(1).getText();
        if (currentScope.resolve(ptrName) == null) errors.add("Ponteiro não declarado: " + ptrName);
        if (currentScope.resolve(varName) == null) errors.add("Variável alvo não declarada: " + varName);
        else currentScope.initialize(ptrName);
    }

    // Atribuição e Uso
    @Override public void exitAtrib(LangParser.AtribContext ctx) {
        String varName = ctx.VAR().getText();
        
        // Atribuição de Array: arr[0] = ...
        if (ctx.getText().contains("[") && ctx.getText().contains("]")) {
            SymbolInfo info = currentScope.resolve(varName);
            if (info == null) errors.add("Array não declarado: " + varName);
            else if (!info.type.endsWith("[]")) errors.add("Variável não é array: " + varName);
            return;
        }

        if (ctx.typeSpec() != null) {
            String type = ctx.typeSpec().getText();
            // Verifica se expression existe e não está vazia antes de acessar
            InitState state = (!ctx.expression().isEmpty() || ctx.funcinvoc() != null) ? InitState.INIT : InitState.UNINIT;
            currentScope.define(varName, type, state);
        } else {
            SymbolInfo info = currentScope.resolve(varName);
            if (info == null) errors.add("Variável não declarada: " + varName);
            else currentScope.initialize(varName);
        }
    }

    @Override public void exitFactor(LangParser.FactorContext ctx) {
        if (ctx.FORMATSTRING() != null) return;
        // Endereço &var
        if (ctx.getText().startsWith("&")) {
            if (currentScope.resolve(ctx.VAR().getText()) == null) errors.add("Variável não declarada: " + ctx.VAR().getText());
            return;
        }
        
        // Validação de uso normal
        if (ctx.VAR() != null && ctx.funcinvoc() == null && ctx.structaccess() == null && ctx.unionaccess() == null) {
            String name = ctx.VAR().getText();
            // Acesso a array arr[i]
            if (ctx.getText().contains("[")) {
                if (currentScope.resolve(name) == null) errors.add("Array não declarado: " + name);
                return;
            }

            SymbolInfo info = currentScope.resolve(name);
            if (info == null) {
                if (declaredFunctions.containsKey(name)) errors.add("Erro: '" + name + "' é uma função. Use '()'.");
                else errors.add("Variável não declarada: " + name);
            } else if (info.state == InitState.UNINIT) {
                errors.add("ALERTA (DFA): Uso de variável não inicializada: " + name);
            }
        }
    }

    @Override public void exitInput(LangParser.InputContext ctx) {
        if (ctx.SCAN() != null) {
            validateScanfFormat(ctx.FORMATSTRING().getText(), ctx.VAR());
            for (TerminalNode varNode : ctx.VAR()) {
                String varName = varNode.getText();
                if (currentScope.resolve(varName) == null) errors.add("Variável não declarada no scanf: " + varName);
                else currentScope.initialize(varName);
            }
        }
    }
    
    @Override public void exitOutput(LangParser.OutputContext ctx) {
        if (ctx.PRINT() != null) validatePrintfFormat(ctx.FORMATSTRING().getText(), ctx.expression());
    }
    
    @Override public void exitProg(LangParser.ProgContext ctx) {
        if (!hasMainFunction) errors.add("Erro: Função main não encontrada.");
    }
    
    @Override public void exitFuncinvoc(LangParser.FuncinvocContext ctx) {
        String name = ctx.VAR().getText();
        if (!declaredFunctions.containsKey(name)) errors.add("Função não declarada: " + name);
    }

    // Stubs
    @Override public void exitStructaccess(LangParser.StructaccessContext ctx) {}
    @Override public void exitUnionaccess(LangParser.UnionaccessContext ctx) {}
    @Override public void exitSwitchstmt(LangParser.SwitchstmtContext ctx) {}
    @Override public void exitCond(LangParser.CondContext ctx) {}
    @Override public void exitDowhilestmt(LangParser.DowhilestmtContext ctx) {}
    @Override public void exitWhilestmt(LangParser.WhilestmtContext ctx) {}
    @Override public void exitForstmt(LangParser.ForstmtContext ctx) {}
    @Override public void exitPointerdereference(LangParser.PointerdereferenceContext ctx) {}
    @Override public void exitExpression(LangParser.ExpressionContext ctx) {}
}