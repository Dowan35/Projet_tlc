import org.antlr.runtime.tree.*;

public class ManualVisitor {
    private SymbolTable symbolTable;

    public ManualVisitor() {
        this.symbolTable = new SymbolTable();
    }

    public void visit(Tree node) {
        if (node == null) {
            return;
        }

        switch (node.getType()) {
            case AstParser.FUNCTION:
                visitFunction(node);
                break;
            case AstParser.DEFINITION:
                visitDefinition(node);
                break;
            case AstParser.INPUT:
                visitInput(node);
                break;
            case AstParser.ASSIGN:
                visitAssign(node);
                break;
            case AstParser.OUTPUT:
                visitOutput(node);
                break;
            default:
                // Parcourir les enfants si le nœud n'est pas directement traité
                for (int i = 0; i < node.getChildCount(); i++) {
                    visit(node.getChild(i));
                }
        }
    }

    private void visitFunction(Tree node) {
        String functionName = node.getChild(0).getText();
        System.out.println("Function: " + functionName);

        // Ajouter la fonction à la table des symboles globales
        symbolTable.addGlobalSymbol(functionName, "Function");

        // Entrer dans le scope de la fonction
        symbolTable.enterScope();

        // Parcourir les enfants de la définition
        for (int i = 1; i < node.getChildCount(); i++) {
            visit(node.getChild(i));
        }

        // Quitter le scope de la fonction
        symbolTable.exitScope();
    }

    private void visitDefinition(Tree node) {
        for (int i = 0; i < node.getChildCount(); i++) {
            visit(node.getChild(i));
        }
    }

    private void visitInput(Tree node) {
        for (int i = 0; i < node.getChildCount(); i++) {
            String variable = node.getChild(i).getText();
            symbolTable.addLocalSymbol(variable, "Input");
            System.out.println("Input variable: " + variable);
        }
    }

    private void visitAssign(Tree node) {
        String variable = node.getChild(0).getText();
        String expression = node.getChild(1).getText();
        symbolTable.addLocalSymbol(variable, "Assigned Expression: " + expression);
        System.out.println("Assignment: " + variable + " = " + expression);
    }

    private void visitOutput(Tree node) {
        for (int i = 0; i < node.getChildCount(); i++) {
            String variable = node.getChild(i).getText();
            System.out.println("Output variable: " + variable);
        }
    }

    public void printSymbolTable() {
        symbolTable.printTable();
    }
}
