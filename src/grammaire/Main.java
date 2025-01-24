    import org.antlr.runtime.*;
    import org.antlr.runtime.tree.CommonTree;
    import org.antlr.runtime.tree.Tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
    import java.io.FileWriter;
    import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

    import antlr.WhileLexer;
    import antlr.WhileParser;

    public class Main {

        // Fonction pour afficher l'AST de manière hiérarchique
        public static void printTree(Tree tree, String prefix, boolean isTail) {
            if (tree == null)
                return;

            System.out.println(prefix + (isTail ? "└── " : "├── ") + "[" + tree.getText() + "]");

            for (int i = 0; i < tree.getChildCount(); i++) {
                boolean isLastChild = (i == tree.getChildCount() - 1);
                printTree(tree.getChild(i), prefix + (isTail ? "    " : "│   "), isLastChild);
            }
        }

        public static void main(String[] args) throws Exception {
            if (args.length < 1) {
                // Lire l'entrée depuis un fichier
                String file = "./grammaire/codesExamples/function.txt";
            } else {
                // Récupère le chemin du fichier à analyser depuis les arguments
                String file = args[0];
            }

            // Fichier de sortie pour le code trois adresses
            String outputFile = "./grammaire/codesExamples/function.3a";
        
            InputStream fileInputStream = new FileInputStream(file);
            ANTLRInputStream inputStream = new ANTLRInputStream(fileInputStream);
        
            // Initialisation du Lexer
            WhileLexer lexer = new WhileLexer(inputStream);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        
            // Initialisation du Parser
            WhileParser parser = new WhileParser(tokenStream);
        
            try {
                // Analyse syntaxique et récupération de l'AST
                WhileParser.program_return result = parser.program(); // Résultat du parsing
                CommonTree astRoot = (CommonTree) result.getTree(); // Récupérer l'AST
                System.out.println("Analyse réussie !");
        
                // Afficher l'AST
                System.out.println("\nAST :");
                printTree(astRoot, "", true);
        
                // Analyse sémantique
                ASTVisitor visitor = new ASTVisitor();
                visitor.visit(astRoot);
                if (visitor.hasErrors()) {
                    System.err.println("\nErreurs sémantiques :");
                    for (String error : visitor.getErrors()) {
                        System.err.println(error);
                    }
                } else {
                    System.out.println("\nAnalyse sémantique réussie !");
        
                    // Génération du code 3 adresses
                    ThreeAddressCodeGenerator generator = new ThreeAddressCodeGenerator();
                    List<String> tacCode = generator.generateCode(astRoot);
        
                    // Affichage du code trois adresses généré
                    System.out.println("\nCode trois adresses généré :");
                    for (String line : tacCode) {
                        System.out.println(line);
                    }
        
                    // Écriture du code trois adresses dans un fichier
                    try (FileWriter fileWriter = new FileWriter(outputFile)) {
                        for (String line : tacCode) {
                            fileWriter.write(line + "\n");
                        }
                        System.out.println("\nCode trois adresses écrit dans le fichier : " + outputFile);
                    }
                }
        
                // Compiler le fichier C++ 3adtoCplus.cpp en un exécutable nommé "translator"
                ProcessBuilder compileProcess = new ProcessBuilder("g++", "-o", "./grammaire/translator", "./grammaire/3adtoCplus.cpp");
                compileProcess.directory(new File("./grammaire")); // Répertoire 'grammaire' où se trouve 3adtoCplus.cpp
                compileProcess.redirectErrorStream(true);
                Process compile = compileProcess.start();

        
                // Lire et afficher les erreurs de compilation
                BufferedReader compileErrorOutput = new BufferedReader(new InputStreamReader(compile.getErrorStream()));
                String errorLine;
                while ((errorLine = compileErrorOutput.readLine()) != null) {
                    System.err.println("Erreur de compilation : " + errorLine);
                }
        
                compile.waitFor();  // Attendre la fin de la compilation
        
                // Vérifier si la compilation a réussi
                if (compile.exitValue() != 0) {
                    System.err.println("Erreur lors de la compilation du programme C++");
                    return;  // Sortir si la compilation échoue
                }
        
                // Si la compilation a réussi, exécuter l'exécutable "translator"
                ProcessBuilder executeCpp = new ProcessBuilder(
                    "./grammaire/translator", "codesExamples/function.3a", "./grammaire/codesExamples/function.cpp"
                );
                executeCpp.directory(new File("./grammaire")); // Répertoire 'grammaire' où se trouve l'exécutable 'translator'
                executeCpp.redirectErrorStream(true);
                Process cppProcess = executeCpp.start();
                int exitCode = cppProcess.waitFor();  // Attendre que l'exécution soit terminée
        
                if (exitCode == 0) {
                    System.out.println("Le code C++ a été généré avec succès dans : ./grammaire/codesExamples/function.cpp");
                } else {
                    System.err.println("Erreur lors de l'exécution du programme C++");
                }
        
            } catch (RecognitionException e) {
                System.err.println("Erreur d'analyse syntaxique : " + e.getMessage());
            } catch (Exception e) {
                // Gérer les erreurs générales (parsing, IO, etc.)
                e.printStackTrace();
            }
        }
    }
