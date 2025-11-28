package Lang;

import grammar.*;
import java.util.*;
import org.antlr.v4.runtime.tree.TerminalNode;

public class SemanticLangListener extends LangBaseListener {
    // Armazenamento de erros e tabelas de símbolos
    public final List<String> errors = new ArrayList<>();
    public final Set<String> declaredVariables = new HashSet<>();
    public final Map<String, String> variableTypes = new HashMap<>();
    public final Map<String, LangParser.FunctionContext> declaredFunctions = new HashMap<>();
    public final Map<String, Map<String, String>> declaredStructs = new HashMap<>();
    public final Map<String, Map<String, String>> declaredUnions = new HashMap<>();
    public final Map<String, Object> defines = new HashMap<>();
    public final Set<String> includedLibs = new HashSet<>();
    public boolean hasMainFunction = false;
    
    // Pilha de escopos para resolução de variáveis
    private Stack<Scope> scopeStack = new Stack<>();
    private Scope currentScope = new Scope(null);

    // Classe interna para representar um escopo
    private class Scope {
        private final Map<String, String> variables = new HashMap<>();
        private final Scope parent;
        
        public Scope(Scope parent) {
            this.parent = parent;
        }
        
        public void define(String name, String type) {
            variables.put(name, type);
        }
        
        public String resolve(String name) {
            String type = variables.get(name);
            if (type != null) return type;
            return parent != null ? parent.resolve(name) : null;
        }
    }

    // -------------------------------------------------------
    // GERENCIAMENTO DE FUNÇÕES E ESCOPOS
    // -------------------------------------------------------

    @Override
    public void enterFunction(LangParser.FunctionContext ctx) {
        String funcName = ctx.VAR() != null ? ctx.VAR().getText() : "main";
        
        if (declaredFunctions.containsKey(funcName)) {
            errors.add("Function already declared: " + funcName);
        } else {
            declaredFunctions.put(funcName, ctx);
        }
        
        if (funcName.equals("main")) {
            hasMainFunction = true;
        }
        
        // Cria o escopo da função e EMPILHA
        Scope functionScope = new Scope(currentScope);
        scopeStack.push(currentScope);
        currentScope = functionScope;

        // Registra parâmetros no escopo da função
        if (ctx.params() != null) {
            List<TerminalNode> params = ctx.params().VAR();
            List<LangParser.TypeSpecContext> types = ctx.params().typeSpec();
            
            for (int i = 0; i < params.size(); i++) {
                String paramName = params.get(i).getText();
                String paramType = types.get(i).getText();
                
                currentScope.define(paramName, paramType);
                declaredVariables.add(paramName);
                variableTypes.put(paramName, paramType);
            }
        }
    }

    @Override
    public void exitFunction(LangParser.FunctionContext ctx) {
        // Desempilha o escopo ao sair da função
        if (!scopeStack.isEmpty()) {
            currentScope = scopeStack.pop();
        }
    }

    @Override
    public void enterFnBlock(LangParser.FnBlockContext ctx) {
        // Apenas cria novo escopo se NÃO for o bloco principal da função
        // (pois enterFunction já criou o escopo principal para conter os parâmetros)
        if (!(ctx.getParent() instanceof LangParser.FunctionContext)) {
            Scope blockScope = new Scope(currentScope);
            scopeStack.push(currentScope);
            currentScope = blockScope;
        }
    }

    @Override
    public void exitFnBlock(LangParser.FnBlockContext ctx) {
        // Apenas desempilha se NÃO for o bloco principal da função
        if (!(ctx.getParent() instanceof LangParser.FunctionContext)) {
            if (!scopeStack.isEmpty()) {
                currentScope = scopeStack.pop();
            }
        }
    }

    // -------------------------------------------------------
    // VERIFICAÇÃO DE VARIÁVEIS GLOBAIS, STRUCTS E UNIONS
    // -------------------------------------------------------

    @Override
    public void exitGlobalVariable(LangParser.GlobalVariableContext ctx) {
        if (ctx.DEFINE() != null) {
            String name = ctx.VAR().getText();
            defines.put(name, null); // Valor será resolvido no interpretador
        }
    }

    @Override
    public void exitStructdecl(LangParser.StructdeclContext ctx) {
        String structName = ctx.VAR().getText();
        if (declaredStructs.containsKey(structName)) {
            errors.add("Structure already declared: " + structName);
            return;
        }
        Map<String, String> fields = new HashMap<>();
        if (ctx.structfieldList() != null) {
            for (LangParser.StructfieldsContext field : ctx.structfieldList().structfields()) {
                String fieldName = field.VAR().getText();
                String fieldType = field.typeSpec().getText();
                if (fields.containsKey(fieldName)) {
                    errors.add("Duplicate field in structure " + structName + ": " + fieldName);
                    continue;
                }
                fields.put(fieldName, fieldType);
            }
        }
        declaredStructs.put(structName, fields);
    }

    @Override
    public void exitUniondecl(LangParser.UniondeclContext ctx) {
        String unionName = ctx.VAR().getText();
        if (declaredUnions.containsKey(unionName)) {
            errors.add("Union already declared: " + unionName);
            return;
        }
        Map<String, String> fields = new HashMap<>();
        if (ctx.unionfieldList() != null) {
            for (LangParser.UnionfieldsContext field : ctx.unionfieldList().unionfields()) {
                String fieldName = field.VAR().getText();
                String fieldType = field.typeSpec().getText();
                fields.put(fieldName, fieldType);
            }
        }
        declaredUnions.put(unionName, fields);
    }

    @Override
    public void exitStructdeclaration(LangParser.StructdeclarationContext ctx) {
        String structType = ctx.VAR(0).getText();
        String varName = ctx.VAR(1).getText();
        
        if (!declaredStructs.containsKey(structType)) {
            errors.add("Structure not declared: " + structType);
            return;
        }
        
        currentScope.define(varName, "struct:" + structType);
        declaredVariables.add(varName);
        variableTypes.put(varName, "struct:" + structType);
    }

    @Override
    public void exitUniondeclaration(LangParser.UniondeclarationContext ctx) {
        String unionVar = ctx.VAR(0).getText();
        String instanceName = ctx.VAR(1).getText();
        
        if (!declaredUnions.containsKey(unionVar)) {
            errors.add("Union type not declared: " + unionVar);
            return;
        }
        
        declaredVariables.add(instanceName);
        variableTypes.put(instanceName, "union:" + unionVar);
        currentScope.define(instanceName, "union:" + unionVar);
    }

    // -------------------------------------------------------
    // VERIFICAÇÃO DE ATRIBUIÇÕES (AQUI ESTAVA O PROBLEMA)
    // -------------------------------------------------------

    @Override
    public void exitAtrib(LangParser.AtribContext ctx) {
        String varName = ctx.VAR().getText();
        
        if (ctx.typeSpec() != null) {
            // DECLARAÇÃO E INICIALIZAÇÃO: int fat = ...
            String varType = ctx.typeSpec().getText();
            
            if (currentScope.resolve(varName) != null) {
                errors.add("Variable already declared: " + varName);
                return;
            }
            
            // Regra 1: typeSpec VAR AT expression
            if (ctx.expression() != null) {
                String exprType = getExpressionType(ctx.expression());
                if (!isCompatibleType(varType, exprType)) {
                    errors.add("Incompatible type in variable initialization: " + varName + 
                               " (expected " + varType + ", got " + exprType + ")");
                    return;
                }
            }
            // Regra 2: typeSpec VAR AT funcinvoc (Chamada explícita na gramática)
            else if (ctx.funcinvoc() != null) {
                 String funcName = ctx.funcinvoc().VAR().getText();
                 if (declaredFunctions.containsKey(funcName)) {
                     LangParser.FunctionContext funcCtx = declaredFunctions.get(funcName);
                     String returnType = funcCtx.typeSpec() != null ? funcCtx.typeSpec().getText() : "int";
                     
                     if (!isCompatibleType(varType, returnType)) {
                         errors.add("Incompatible type: cannot assign function returning " + returnType + " to " + varType);
                         return;
                     }
                     validateFunctionArguments(ctx.funcinvoc(), funcCtx);
                 } else {
                     errors.add("Function not declared: " + funcName);
                     return;
                 }
            }
            
            currentScope.define(varName, varType);
            declaredVariables.add(varName);
            variableTypes.put(varName, varType);

        } else {
             // ATRIBUIÇÃO SIMPLES: fat = ...
             String varType = currentScope.resolve(varName);
             if (varType == null) {
                 if (declaredVariables.contains(varName)) {
                     varType = variableTypes.get(varName);
                 } else {
                     errors.add("Variable not declared: " + varName);
                     return;
                 }
             }
             
             if (ctx.getText().contains("++") || ctx.getText().contains("--")) {
                if (!isNumericType(varType)) {
                    errors.add("Increment/decrement operator requires numeric type: " + varName);
                }
                return;
            }
             
             if (ctx.expression() != null) {
                String exprType = getExpressionType(ctx.expression());
                if (!isCompatibleType(varType, exprType)) {
                    errors.add("Incompatible type in assignment: " + varName + 
                               " (expected " + varType + ", got " + exprType + ")");
                }
             }
        }
    }

    // -------------------------------------------------------
    // SISTEMA DE TIPOS (GetExpressionType e GetFactorType)
    // -------------------------------------------------------

    private String getExpressionType(LangParser.ExpressionContext expr) {
        if (expr == null) return "unknown";
        
        if (expr.term() != null) {
            String termType = getTermType(expr.term());
            // Se houver cauda (+, -), assume que o tipo numérico se mantém
            if (!expr.termTail().isEmpty()) {
                if (isNumericType(termType)) return termType;
            }
            return termType;
        }
        
        if (expr.VAR() != null) {
            String varName = expr.VAR().getText();
            String varType = currentScope.resolve(varName);
            if (varType != null) return varType;
            return variableTypes.getOrDefault(varName, "unknown");
        }
        return "unknown";
    }

    private String getTermType(LangParser.TermContext term) {
        if (term == null) return "unknown";
        return getFactorType(term.factor());
    }

    private String getFactorType(LangParser.FactorContext factor) {
        if (factor == null) return "unknown";
        
        if (factor.NUM() != null) return "int";
        if (factor.DECIM() != null) return "float";
        
        // --- CORREÇÃO: Verifica chamada de função dentro da expressão ---
        if (factor.funcinvoc() != null) {
            String funcName = factor.funcinvoc().VAR().getText();
            if (declaredFunctions.containsKey(funcName)) {
                LangParser.FunctionContext funcCtx = declaredFunctions.get(funcName);
                // Retorna o tipo de retorno da função
                return funcCtx.typeSpec() != null ? funcCtx.typeSpec().getText() : "int";
            }
            return "unknown"; 
        }
        // ---------------------------------------------------------------
        
        if (factor.VAR() != null) {
            String varName = factor.VAR().getText();
            String varType = currentScope.resolve(varName);
            if (varType != null) return varType;
            return variableTypes.getOrDefault(varName, "unknown");
        }
        
        if (factor.expression() != null) {
            return getExpressionType(factor.expression());
        }
        
        return "unknown";
    }

    // -------------------------------------------------------
    // MÉTODOS AUXILIARES E OUTROS VISITORS
    // -------------------------------------------------------

    private boolean isNumericType(String type) {
        return type != null && (type.equals("int") || type.equals("float") || type.equals("double") || type.equals("char"));
    }
    
    private String getWidestType(String type1, String type2) {
        if (type1.equals("double") || type2.equals("double")) return "double";
        if (type1.equals("float") || type2.equals("float")) return "float";
        return "int";
    }

    private boolean isCompatibleType(String expectedType, String actualType) {
        if (expectedType == null || actualType == null) return false;
        if (actualType.equals("unknown")) return false; // Falha se não conseguiu resolver o tipo
        if (expectedType.equals(actualType)) return true;
        if (isNumericType(expectedType) && isNumericType(actualType)) return true;
        return false;
    }

    @Override
    public void exitInput(LangParser.InputContext ctx) {
        if (ctx.SCAN() != null) {
            String format = ctx.FORMATSTRING().getText();
            List<TerminalNode> vars = ctx.VAR();
            validateScanfFormat(format, vars);
        }
    }

    private void validateScanfFormat(String format, List<TerminalNode> vars) {
        format = format.substring(1, format.length() - 1);
        int formatCount = 0;
        for (int i = 0; i < format.length(); i++) {
            if (format.charAt(i) == '%') {
                if (i + 1 < format.length() && "dfsc".indexOf(format.charAt(i + 1)) >= 0) {
                    formatCount++;
                }
            }
        }
        if (formatCount != vars.size()) {
            errors.add("Number of arguments does not match format specifiers in scanf");
        }
    }

    @Override
    public void exitOutput(LangParser.OutputContext ctx) {
        if (ctx.PRINT() != null) {
            String format = ctx.FORMATSTRING().getText();
            List<LangParser.ExpressionContext> expressions = ctx.expression();
            validatePrintfFormat(format, expressions);
        }
    }

    private void validatePrintfFormat(String format, List<LangParser.ExpressionContext> expressions) {
        format = format.substring(1, format.length() - 1);
        int formatCount = 0;
        for (int i = 0; i < format.length(); i++) {
            if (format.charAt(i) == '%') {
                if (i + 1 < format.length() && "dfsc".indexOf(format.charAt(i + 1)) >= 0) {
                    formatCount++;
                }
            }
        }
        if (formatCount != expressions.size()) {
            errors.add("Number of arguments does not match format specifiers in printf");
        }
    }

    @Override
    public void exitArraydecl(LangParser.ArraydeclContext ctx) {
        String arrayName = ctx.VAR().getText();
        String arrayType = ctx.typeSpec().getText();
        
        if (declaredVariables.contains(arrayName)) {
            errors.add("Array already declared: " + arrayName);
            return;
        }
        
        try {
            int size = Integer.parseInt(ctx.NUM().getText());
            if (size <= 0) {
                errors.add("Array size must be positive: " + arrayName);
                return;
            }
            
            declaredVariables.add(arrayName);
            variableTypes.put(arrayName, arrayType + "[]");
            currentScope.define(arrayName, arrayType + "[]");
            
            if (ctx.arrayelems() != null) {
                validateArrayInitialization(ctx, arrayName, arrayType, size);
            }
        } catch (NumberFormatException e) {
            errors.add("Invalid array size: " + arrayName);
        }
    }

    private void validateArrayInitialization(LangParser.ArraydeclContext ctx, String arrayName, String arrayType, int size) {
        List<LangParser.ExpressionContext> elements = ctx.arrayelems().expression();
        if (elements.size() > size) {
            errors.add("Initialization exceeds array size: " + arrayName);
            return;
        }
        for (LangParser.ExpressionContext element : elements) {
            String elementType = getExpressionType(element);
            if (!isCompatibleType(arrayType, elementType)) {
                errors.add("Incompatible type in array initialization: " + arrayName);
            }
        }
    }

    @Override
    public void exitPointerdecl(LangParser.PointerdeclContext ctx) {
        String pointerName = ctx.VAR().getText();
        String baseType = ctx.typeSpec().getText();
        if (declaredVariables.contains(pointerName)) {
            errors.add("Pointer already declared: " + pointerName);
            return;
        }
        declaredVariables.add(pointerName);
        variableTypes.put(pointerName, baseType + "*");
        currentScope.define(pointerName, baseType + "*");
    }

    @Override
    public void exitPointerassign(LangParser.PointerassignContext ctx) {
        String pointerName = ctx.VAR(0).getText();
        String varName = ctx.VAR(1).getText();
        if (!declaredVariables.contains(pointerName)) {
            errors.add("Pointer not declared: " + pointerName);
            return;
        }
        if (!declaredVariables.contains(varName)) {
            errors.add("Variable not declared: " + varName);
            return;
        }
        String pointerType = variableTypes.get(pointerName);
        String varType = variableTypes.get(varName);
        if (!pointerType.endsWith("*")) {
            errors.add("Variable is not a pointer: " + pointerName);
            return;
        }
        String baseType = pointerType.substring(0, pointerType.length() - 1);
        if (!baseType.equals(varType)) {
            errors.add("Incompatible type in address assignment");
        }
    }

    @Override
    public void exitStructaccess(LangParser.StructaccessContext ctx) {
        String structVar = ctx.VAR(0).getText();
        String field = ctx.VAR(1).getText();
        if (!declaredVariables.contains(structVar)) {
            errors.add("Struct instance not declared: " + structVar);
            return;
        }
        String type = variableTypes.get(structVar);
        if (!type.startsWith("struct:")) {
            errors.add("Variable is not a struct: " + structVar);
            return;
        }
        String structType = type.substring(7);
        Map<String, String> fields = declaredStructs.get(structType);
        if (!fields.containsKey(field)) {
            errors.add("Field does not exist in struct: " + field);
            return;
        }
        if (ctx.expression() != null) {
            String exprType = getExpressionType(ctx.expression());
            String fieldType = fields.get(field);
            if (!isCompatibleType(fieldType, exprType)) {
                errors.add("Incompatible type in struct field assignment");
            }
        }
    }

    @Override
    public void exitUnionaccess(LangParser.UnionaccessContext ctx) {
        String unionVar = ctx.VAR(0).getText();
        String field = ctx.VAR(1).getText();
        if (!declaredVariables.contains(unionVar)) {
            errors.add("Union instance not declared: " + unionVar);
            return;
        }
        String type = variableTypes.get(unionVar);
        if (type == null || !type.startsWith("union:")) {
            errors.add("Variable is not a union: " + unionVar);
            return;
        }
        String unionType = type.substring(6);
        Map<String, String> fields = declaredUnions.get(unionType);
        if (fields == null || !fields.containsKey(field)) {
            errors.add("Field does not exist in union: " + field);
            return;
        }
        if (ctx.expression() != null) {
            String exprType = getExpressionType(ctx.expression());
            String fieldType = fields.get(field);
            if (!isCompatibleType(fieldType, exprType)) {
                errors.add("Incompatible type in union field assignment");
            }
        }
    }

    @Override
    public void exitFuncinvoc(LangParser.FuncinvocContext ctx) {
        String funcName = ctx.VAR().getText();
        if (!declaredFunctions.containsKey(funcName)) {
            errors.add("Function not declared: " + funcName);
            return;
        }
        LangParser.FunctionContext funcDecl = declaredFunctions.get(funcName);
        validateFunctionArguments(ctx, funcDecl);
    }

    private void validateFunctionArguments(LangParser.FuncinvocContext invocation, LangParser.FunctionContext function) {
        List<LangParser.ExpressionContext> arguments = 
            invocation.argumentos() != null ? invocation.argumentos().expression() : new ArrayList<>();
            
        if (function.params() != null) {
            List<TerminalNode> params = function.params().VAR();
            List<LangParser.TypeSpecContext> paramTypes = function.params().typeSpec();
            
            if (params.size() != arguments.size()) {
                errors.add("Incorrect number of arguments in call to function: " + invocation.VAR().getText());
                return;
            }
            
            for (int i = 0; i < arguments.size(); i++) {
                String paramType = paramTypes.get(i).getText();
                String argType = getExpressionType(arguments.get(i));
                if (!isCompatibleType(paramType, argType)) {
                    errors.add("Incompatible type for argument " + (i + 1) + " in function call " + invocation.VAR().getText());
                }
            }
        } else if (!arguments.isEmpty()) {
            errors.add("Function " + invocation.VAR().getText() + " takes no parameters but was called with arguments");
        }
    }

    @Override
    public void exitProg(LangParser.ProgContext ctx) {
        if (!hasMainFunction) {
            errors.add("Program does not have a main function");
        }
    }

    @Override
    public void exitPreprocessorDirective(LangParser.PreprocessorDirectiveContext ctx) {
        String lib = ctx.LIB().getText();
        lib = lib.substring(1, lib.length() - 1);
        if (includedLibs.contains(lib)) {
            errors.add("Library already included: " + lib);
            return;
        }
        includedLibs.add(lib);
    }

    @Override
    public void exitSwitchstmt(LangParser.SwitchstmtContext ctx) {
        String varName = ctx.VAR().getText();
        if (!declaredVariables.contains(varName)) {
            errors.add("Variable not declared in switch: " + varName);
            return;
        }
        String varType = variableTypes.get(varName);
        if (!varType.equals("int") && !varType.equals("char")) {
            errors.add("Switch requires int or char variable");
        }
        Set<String> caseValues = new HashSet<>();
        for (LangParser.CaseClauseContext caseCtx : ctx.caseClause()) {
            String caseValue = caseCtx.NUM().getText();
            if (!caseValues.add(caseValue)) {
                errors.add("Duplicate case value: " + caseValue);
            }
        }
    }

    @Override
    public void exitExpression(LangParser.ExpressionContext ctx) {
        if (ctx.VAR() != null) {
            String varName = ctx.VAR().getText();
            if (!declaredVariables.contains(varName)) {
                errors.add("Variable not declared: " + varName);
            }
        }
    }

    @Override
    public void exitCond(LangParser.CondContext ctx) {
        if (ctx.RELOP() != null) {
            String leftType = getCondType(ctx.cond(0));
            String rightType = getCondType(ctx.cond(1));
            if (!isCompatibleType(leftType, rightType)) {
                errors.add("Incompatible types in comparison");
            }
        }
    }

    private String getCondType(LangParser.CondContext ctx) {
        if (ctx.expression() != null) {
            return getExpressionType(ctx.expression());
        }
        return "boolean";
    }

    @Override
    public void exitDowhilestmt(LangParser.DowhilestmtContext ctx) {
        validateCondition(ctx.cond());
    }

    @Override
    public void exitWhilestmt(LangParser.WhilestmtContext ctx) {
        validateCondition(ctx.cond());
    }

    @Override
    public void exitForstmt(LangParser.ForstmtContext ctx) {
        validateCondition(ctx.cond());
    }

    private void validateCondition(LangParser.CondContext ctx) {
        String condType = getCondType(ctx);
        if (ctx.expression() != null && !isNumericType(condType) && !condType.equals("boolean")) {
            errors.add("Condition must be numeric or boolean");
        }
    }
    
    public List<String> getErrors() { return errors; }
    public boolean hasErrors() { return !errors.isEmpty(); }
}