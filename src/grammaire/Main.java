import org.antlr.runtime.*; // Import des classes d'ANTLR (CommonTokenStream, ANTLRInputStream, etc.)
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import java.io.FileInputStream;
import java.io.InputStream;

import antlr.WhileLexer;
import antlr.WhileParser;

public class Main {
    public static void printTree(Tree tree, String prefix, boolean isTail) {
        if (tree == null)
            return;

        // Afficher le nœud actuel avec des bordures
        System.out.println(prefix + (isTail ? "└── " : "├── ") + "[" + tree.getText() + "]");

        // Parcourir les enfants
        for (int i = 0; i < tree.getChildCount(); i++) {
            boolean isLastChild = (i == tree.getChildCount() - 1);
            printTree(tree.getChild(i), prefix + (isTail ? "    " : "│   "), isLastChild);
        }
    }

    public static void main(String[] args) throws Exception {
        // String input = "function invalidVar :\nread X$\n%\nResult := X$\n%\nwrite
        // Result";
        // ANTLRStringStream inputStream = new ANTLRStringStream(input); // Lecture
        // depuis une chaîne

        // Lire l'entrée depuis un fichier
        // String file = "./codesExamples/function.txt";
        //Path filePath = Paths.get(file);
        //String fileContent = Files.readString(filePath);

        // String file = "./src/codesExamples/allFunctions.txt";
        String file = "./grammaire/codesExamples/test.txt";
        //String file = "./src/codesExamples/function.txt";
        InputStream fileInputStream = new FileInputStream(file);
        ANTLRInputStream inputStream = new ANTLRInputStream(fileInputStream);

        // 2. Initialisation du Lexer
        WhileLexer lexer = new WhileLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        // 3. Initialisation du Parser
        WhileParser parser = new WhileParser(tokenStream);

        // 4. Lancer l'analyse syntaxique et sémantique
        try {
            WhileParser.program_return result = parser.program(); // Récupérer le résultat
            CommonTree astRoot = (CommonTree) result.getTree(); // Extraire l'AST
            System.out.println("Analyse réussie !");

            // Affichez l'AST
            System.out.println("AST :");
            printTree(astRoot, "", true);

            // Analyse sémantique avec le visiteur
            ASTVisitor visitor = new ASTVisitor();
            visitor.visit(astRoot);
            if (visitor.hasErrors()) {
                System.err.println("Erreurs sémantiques :");
                for (String error : visitor.getErrors()) {
                    System.err.println(error);
                }
            } else {
                System.out.println("Analyse sémantique réussie !");
            }

        } catch (RecognitionException e) {
            System.err.println("Erreur d'analyse : " + e.getMessage());
        } catch (Exception e) {
            // Gérer les erreurs générales (parsing, IO, etc.)
            e.printStackTrace();
        }
    }
}