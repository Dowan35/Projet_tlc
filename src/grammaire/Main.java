import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
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
        // Lire l'entrée depuis un fichier
        String file = "./grammaire/codesExamples/function.txt";
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

        } catch (RecognitionException e) {
            System.err.println("Erreur d'analyse syntaxique : " + e.getMessage());
        } catch (Exception e) {
            // Gérer les erreurs générales (parsing, IO, etc.)
            e.printStackTrace();
        }
    }
}
