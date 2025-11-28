import java.util.List;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import grammar.LangParser;
import grammar.LangLexer;
import Lang.*;

public class Main {
    public static void main(String[] args) {
        try {
            String inputFile = "input.lang";
            
            CharStream input = CharStreams.fromFileName(inputFile);
            if (input == null) {
                throw new RuntimeException("Could not read file: " + inputFile);
            }
            
            LangLexer lexer = new LangLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            
            LangParser parser = new LangParser(tokens);
            LangErrorListener errorListener = new LangErrorListener();
            parser.removeErrorListeners();
            parser.addErrorListener(errorListener);
            
            ParseTree tree = parser.prog();
            
            if (errorListener.hasErrors()) {
                System.out.println("\nSyntax errors found:");
                List<String> errorMsgs = errorListener.getErrorMessages();
                if (errorMsgs != null && !errorMsgs.isEmpty()) {
                    for (String error : errorMsgs) {
                        System.out.println("  - " + error);
                    }
                }
                return;
            }

            SemanticLangListener semanticListener = new SemanticLangListener();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(semanticListener, tree);

            if (semanticListener.hasErrors()) {
                System.out.println("\nSemantic errors found:");
                for (String error : semanticListener.getErrors()) {
                    System.out.println("  - " + error);
                }
                return;
            }
            
            LangInterpreter interpreter = new LangInterpreter();
            
            interpreter.visit(tree);
            
            System.out.println("\n=== Execution Start ===\n");
            interpreter.executeProgram();
            System.out.println("\n=== Execution End ===");
            interpreter.cleanup();
            
        } catch (Exception e) {
            System.out.println("\nExecution error:");
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}