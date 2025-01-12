
import org.antlr.runtime.*; // Import des classes d'ANTLR (CommonTokenStream, ANTLRInputStream, etc.)
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import java.io.FileInputStream; // Si vous voulez lire l'entrée depuis un fichier
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// import org.antlr.runtime.tree.CommonTree;
// import exception.CheckerException;

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

    public static ASTNode convertTreeToASTNode(Tree tree) {
        if (tree == null)
            return null;

        ASTNode node = new ASTNode(tree.getText(), tree.toString());
        for (int i = 0; i < tree.getChildCount(); i++) {
            node.addChild(convertTreeToASTNode(tree.getChild(i)));
        }
        return node;
    }

    public static void main(String[] args) throws Exception {
        // String input = "function invalidVar :\nread X$\n%\nResult := X$\n%\nwrite
        // Result";
        // ANTLRStringStream inputStream = new ANTLRStringStream(input); // Lecture
        // depuis une chaîne

        // Lire l'entrée depuis un fichier
        String file = "./examples/function.txt";
        Path filePath = Paths.get(file);
        String fileContent = Files.readString(filePath);

        InputStream fileInputStream = new FileInputStream(file);
        ANTLRInputStream inputStream = new ANTLRInputStream(fileInputStream);

        // 2. Initialisation du Lexer
        AstLexer lexer = new AstLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        // 3. Initialisation du Parser
        AstParser parser = new AstParser(tokenStream);

        // Initialisation de la table des symboles
        SymbolTable symbolTable = new SymbolTable();
        parser.setSymbolTable(symbolTable);

        // 4. Lancer l'analyse syntaxique
        try {
            AstParser.program_return result = parser.program(); // Récupérer le résultat
            CommonTree astRoot = (CommonTree) result.getTree(); // Extraire l'AST
            System.out.println("Analyse réussie !");

            // Affichez l'AST
            System.out.println("AST :");
            printTree(astRoot, "", true);
            // ASTNode customAST = convertTreeToASTNode(astRoot);
            // customAST.print("");

            // Parcourir l'AST avec un visiteur manuel
            ManualVisitor visitor = new ManualVisitor();
            System.out.println("Parcours de l'AST avec le visiteur manuel :");
            visitor.visit(astRoot);

            // Afficher la table des symboles
            System.out.println("\nTable des symboles générée :");
            visitor.printSymbolTable();

            // Étape 2 : Vérifier la validité sémantique avec Checker
            Checker checker = new Checker(astRoot, file, fileContent);
            boolean isValid = checker.check();

            // Résultat
            if (isValid) {
                System.out.println("Le programme est valide !");
            } else {
                System.err.println("Le programme contient des erreurs.");
            }

        } catch (RecognitionException e) {
            System.err.println("Erreur d'analyse : " + e.getMessage());
            // } catch (CheckerException e) {
            // // Gérer les erreurs sémantiques détectées par le Checker
            // System.err.println("Erreur sémantique détectée : " + e.getMessage());
        } catch (Exception e) {
            // Gérer les erreurs générales (parsing, IO, etc.)
            e.printStackTrace();
        }
    }
}