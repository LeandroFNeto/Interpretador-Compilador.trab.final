import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import grammar.LangParser;
import grammar.LangLexer;
import Lang.*;

public class Main {
    
    // Processa #include recursivamente
    private static String preprocessIncludes(String filePath, Set<String> visited) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) throw new IOException("Arquivo não encontrado: " + filePath);
        
        String content = Files.readString(file.toPath());
        StringBuilder sb = new StringBuilder();
        String[] lines = content.split("\n");

        for (String line : lines) {
            if (line.trim().startsWith("#include")) {
                String rawLib = line.trim().substring(8).trim();
                
                // Se for biblioteca de sistema <...>, ignoramos a inclusão física
                if (rawLib.startsWith("<") && rawLib.endsWith(">")) {
                    sb.append("// System include ignored: ").append(rawLib).append("\n");
                } 
                // Se for arquivo local "...", incluímos
                else {
                    String lib = rawLib.replaceAll("[\"]", "");
                    String libPath = file.getParent() != null ? file.getParent() + "/" + lib : lib; 
                    
                    if (!visited.contains(libPath)) {
                        visited.add(libPath);
                        // Recursão para includes dentro de includes
                        sb.append(preprocessIncludes(libPath, visited)); 
                    }
                }
            } else {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            // Se não passar argumento, usa input.lang padrão
            String inputFile = (args.length > 0) ? args[0] : "input.lang";
            
            // 1. Pré-processamento
            Set<String> visitedIncludes = new HashSet<>();
            visitedIncludes.add(new File(inputFile).getAbsolutePath());
            String fullCode = preprocessIncludes(inputFile, visitedIncludes);
            
            // 2. Lexing e Parsing
            CharStream input = CharStreams.fromString(fullCode);
            LangLexer lexer = new LangLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LangParser parser = new LangParser(tokens);
            
            // Gestão de Erros
            parser.removeErrorListeners();
            LangErrorListener errorListener = new LangErrorListener();
            parser.addErrorListener(errorListener);
            
            ParseTree tree = parser.prog();
            
            if (errorListener.hasErrors()) {
                System.err.println("\n=== ERROS SINTÁTICOS ===");
                errorListener.getErrorMessages().forEach(System.err::println);
                System.exit(1);
            }

            // 3. Análise Semântica (DFA + Tipos)
            SemanticLangListener semanticListener = new SemanticLangListener();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(semanticListener, tree);

            if (semanticListener.hasErrors()) {
                System.err.println("\n=== ERROS SEMÂNTICOS ===");
                semanticListener.getErrors().forEach(System.err::println);
                System.exit(1);
            }
            
            // 4. Interpretação
            System.out.println("\n=== Execution Start ===\n");
            LangInterpreter interpreter = new LangInterpreter();
            interpreter.visit(tree);
            interpreter.executeProgram();
            System.out.println("\n=== Execution End ===");
            
        } catch (IOException e) {
            System.err.println("Erro de I/O: " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}