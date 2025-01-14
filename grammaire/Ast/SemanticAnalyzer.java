import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.*;
import

class SymbolTable {
    private Map<String, String> functions = new HashMap<>(); // Nom de la fonction -> Définition
    private Map<String, String> variables = new HashMap<>(); // Nom de la variable -> Type ou information

    public void addFunction(String name, String definition) {
        if (functions.containsKey(name)) {
            throw new RuntimeException("La fonction '" + name + "' est déjà définie.");
        }
        functions.put(name, definition);
    }

    public void addVariable(String name, String type) {
        if (variables.containsKey(name)) {
            throw new RuntimeException("La variable '" + name + "' est déjà définie.");
        }
        variables.put(name, type);
    }

    public boolean isFunctionDefined(String name) {
        return functions.containsKey(name);
    }

    public boolean isVariableDefined(String name) {
        return variables.containsKey(name);
    }

    public void printSymbolTable() {
        System.out.println("Table des symboles :");
        System.out.println("Fonctions :");
        for (Map.Entry<String, String> entry : functions.entrySet()) {
            System.out.println(" - " + entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("Variables :");
        for (Map.Entry<String, String> entry : variables.entrySet()) {
            System.out.println(" - " + entry.getKey() + " : " + entry.getValue());
        }
    }
}

public class SemanticAnalyzer {
    private SymbolTable symbolTable = new SymbolTable();

    public void analyze(CommonTree ast) {
        if (ast == null)
            return;

        switch (ast.getType()) {
            case AstLexer.PROGRAM:
                for (Object child : ast.getChildren()) {
                    analyze((CommonTree) child);
                }
                break;

            case AstLexer.FUNCTION:
                String functionName = ast.getChild(0).getText();
                CommonTree functionDefinition = (CommonTree) ast.getChild(1);
                symbolTable.addFunction(functionName, functionDefinition.toStringTree());
                analyze(functionDefinition);
                break;

            case AstLexer.DEFINITION:
                CommonTree inputNode = (CommonTree) ast.getChild(0);
                CommonTree commandsNode = (CommonTree) ast.getChild(1);
                CommonTree outputNode = (CommonTree) ast.getChild(2);
                analyze(inputNode);
                analyze(commandsNode);
                analyze(outputNode);
                break;

            case AstLexer.INPUT:
                for (Object child : ast.getChildren()) {
                    String variableName = ((CommonTree) child).getText();
                    symbolTable.addVariable(variableName, "input");
                }
                break;

            case AstLexer.OUTPUT:
                for (Object child : ast.getChildren()) {
                    String variableName = ((CommonTree) child).getText();
                    if (!symbolTable.isVariableDefined(variableName)) {
                        throw new RuntimeException(
                                "La variable '" + variableName + "' utilisée en sortie n'est pas définie.");
                    }
                }
                break;

            case AstLexer.COMMANDS:
                for (Object child : ast.getChildren()) {
                    analyze((CommonTree) child);
                }
                break;

            case AstLexer.ASSIGN:
                CommonTree varsNode = (CommonTree) ast.getChild(0);
                CommonTree exprNode = (CommonTree) ast.getChild(1);

                for (Object child : varsNode.getChildren()) {
                    String variableName = ((CommonTree) child).getText();
                    symbolTable.addVariable(variableName, "assigned");
                }
                analyze(exprNode);
                break;

            case AstLexer.IF:
            case AstLexer.WHILE:
            case AstLexer.FOR:
                for (Object child : ast.getChildren()) {
                    analyze((CommonTree) child);
                }
                break;

            case AstLexer.VAR:
                String variable = ast.getText();
                if (!symbolTable.isVariableDefined(variable)) {
                    throw new RuntimeException("La variable '" + variable + "' n'est pas définie.");
                }
                break;

            case AstLexer.CALL:
                String calledFunction = ast.getChild(0).getText();
                if (!symbolTable.isFunctionDefined(calledFunction)) {
                    throw new RuntimeException("La fonction '" + calledFunction + "' n'est pas définie.");
                }
                break;

            default:
                for (Object child : ast.getChildren()) {
                    analyze((CommonTree) child);
                }
        }
    }

    public void printSymbolTable() {
        symbolTable.printSymbolTable();
    }

    public static void main(String[] args) throws Exception {
        // Charger l'AST généré par ANTLR
        AstLexer lexer = new AstLexer(new ANTLRFileStream(
                "C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\Ast.g"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AstParser parser = new AstParser(tokens);
        CommonTree ast = (CommonTree) parser.program().getTree();

        // Analyse sémantique
        SemanticAnalyzer analyzer = new SemanticAnalyzer();
        analyzer.analyze(ast);
        analyzer.printSymbolTable();
    }
}
