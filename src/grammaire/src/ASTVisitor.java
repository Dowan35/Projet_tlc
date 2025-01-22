import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime.tree.CommonTree;
import antlr.WhileLexer;

public class ASTVisitor {
    private final SymbolTable symbolTable = new SymbolTable();
    private final List<String> errors = new ArrayList<>();

    public void visit(CommonTree tree) {
        if (tree == null) {
            return;
        }
    
        try {
            switch (tree.getType()) {
                case WhileLexer.SYMB:
                    visitFunctionCall(tree); // Vérifier l'appel de fonction
                    break;
                case WhileLexer.Variable:
                    visitVariable(tree); // Vérifier l'appel de variable
                    break;
                case WhileLexer.PROGRAM:
                    visitProgram(tree);
                    break;
                case WhileLexer.FUNCTION:
                    visitFunction(tree);
                    break;
                case WhileLexer.INPUTS:
                    visitInputs(tree);
                    break;
                case WhileLexer.OUTPUTS:
                    visitOutputs(tree);
                    break;
                case WhileLexer.COMMANDS:
                    visitCommands(tree);
                    break;
                case WhileLexer.LET:
                    visitLet(tree);
                    break;
                case WhileLexer.IF:
                    visitIf(tree);
                    break;
                case WhileLexer.WHILE:
                    visitWhile(tree);
                    break;
                case WhileLexer.FOREACH:
                    visitForeach(tree);
                    break;
                case WhileLexer.FOR:
                    visitFor(tree);
                    break;
                default:
                    visitChildren(tree);
            }
        } catch (RuntimeException e) {
            errors.add(e.getMessage());
        }
    }    

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<String> getErrors() {
        return errors;
    }

    private void visitProgram(CommonTree tree) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            visit((CommonTree) tree.getChild(i));
        }
    }

    private void visitFunction(CommonTree tree) {
        String functionName = tree.getChild(0).getText();
        
        // Vérification si la fonction a déjà été déclarée dans le scope global
        if (symbolTable.isSymbolDeclared(functionName)) {
            throw new RuntimeException("Erreur : Fonction '" + functionName + "' déjà déclarée.");
        }
    
        // Ajouter la fonction dans le scope global
        symbolTable.addSymbol(functionName, "function");
    
        // Créer un nouveau scope pour les paramètres et le corps de la fonction
        symbolTable.enterScope();
        visit((CommonTree) tree.getChild(1)); // Inputs
        visit((CommonTree) tree.getChild(2)); // Commands
        visit((CommonTree) tree.getChild(3)); // Outputs

        //symbolTable.printSymbolTable();
        symbolTable.exitScope();
    }    
    

    private void visitInputs(CommonTree tree) {
        // Les variables d'entrée doivent être ajoutées au scope courant
        for (int i = 0; i < tree.getChildCount(); i++) {
            String varName = tree.getChild(i).getText();
            if (symbolTable.isSymbolInCurrentScope(varName)) {
                throw new RuntimeException("Erreur : Variable '" + varName + "' déjà déclarée en entrée.");
            }
            symbolTable.addSymbol(varName, "input");
        }
    }

    private void visitOutputs(CommonTree tree) {
        // Vérification que toutes les variables de sortie sont déclarées dans le scope
        for (int i = 0; i < tree.getChildCount(); i++) {
            String varName = tree.getChild(i).getText();
            if (!symbolTable.isSymbolDeclared(varName)) {
                throw new RuntimeException("Erreur : Variable '" + varName + "' utilisée dans les sorties mais non déclarée.");
            }
        }
    }

    private void visitCommands(CommonTree tree) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            visit((CommonTree) tree.getChild(i));
        }
    }

    private void visitLet(CommonTree tree) {
        CommonTree varsNode = (CommonTree) tree.getChild(0);
        CommonTree exprsNode = (CommonTree) tree.getChild(1);

        // Vérification des variables déclarées avant de les affecter
        for (int i = 0; i < varsNode.getChildCount(); i++) {
            String varName = varsNode.getChild(i).getText();
            if (!symbolTable.isSymbolDeclared(varName)) {
                symbolTable.addSymbol(varName, "variable"); // Déclare la variable dans le scope courant
            }
        }

        visit(exprsNode); // Visiter les expressions assignées
    }

    private void visitIf(CommonTree tree) {
        CommonTree condition = (CommonTree) tree.getChild(0);
        CommonTree thenCommands = (CommonTree) tree.getChild(1);
        CommonTree elseCommands = tree.getChildCount() > 2 ? (CommonTree) tree.getChild(2) : null;
    
        // Visite de la condition (on ne gère pas les variables ici)
        visit(condition); 
    
        // On commence par visiter les commandes dans "then" et "else", et ajouter les variables au scope global de la fonction
        addVariablesFromCommands(thenCommands);
        if (elseCommands != null) {
            addVariablesFromCommands(elseCommands);
        }
    
        // Maintenant, on entre dans les scopes pour les blocs de commandes
        symbolTable.enterScope();
        visit(thenCommands); // Visite des commandes dans le "then"
        symbolTable.exitScope();
    
        if (elseCommands != null) {
            symbolTable.enterScope();
            visit(elseCommands); // Visite des commandes dans le "else"
            symbolTable.exitScope();
        }
    }
    
    // Fonction pour ajouter les variables de l'ensemble des commandes au scope de la fonction
    private void addVariablesFromCommands(CommonTree commands) {
        for (int i = 0; i < commands.getChildCount(); i++) {
            CommonTree command = (CommonTree) commands.getChild(i);
            if (command.getType() == WhileLexer.LET) {
                // Si c'est une déclaration de variable dans "LET", ajouter au scope
                CommonTree varsNode = (CommonTree) command.getChild(0);
                for (int j = 0; j < varsNode.getChildCount(); j++) {
                    String varName = varsNode.getChild(j).getText();
                    // Ajouter la variable au scope de la fonction si elle n'est pas déjà déclarée
                    if (!symbolTable.isSymbolDeclared(varName)) {
                        symbolTable.addSymbol(varName, "variable");
                    }
                }
            }
        }
    }
    

    private void visitWhile(CommonTree tree) {
        CommonTree condition = (CommonTree) tree.getChild(0);
        CommonTree commands = (CommonTree) tree.getChild(1);

        visit(condition);
        symbolTable.enterScope();
        visit(commands);
        symbolTable.exitScope();
    }

    private void visitForeach(CommonTree tree) {
        String varName = tree.getChild(0).getText();
        CommonTree iterable = (CommonTree) tree.getChild(1);
        CommonTree commands = (CommonTree) tree.getChild(2);

        visit(iterable);
        symbolTable.enterScope();
        symbolTable.addSymbol(varName, "variable");
        visit(commands);
        symbolTable.exitScope();
    }

    private void visitFor(CommonTree tree) {
        CommonTree iterable = (CommonTree) tree.getChild(0);
        CommonTree commands = (CommonTree) tree.getChild(1);

        visit(iterable);
        symbolTable.enterScope();
        visit(commands);
        symbolTable.exitScope();
    }
    // private void visitFor(CommonTree tree) {
    //     // Le premier enfant de FOR est la variable de boucle (Op1)
    //     String loopVarName = tree.getChild(0).getText();

    //     if (symbolTable.resolveSymbol(loopVarName) == null) {
    //         throw new RuntimeException("Erreur sémantique : Fonction '" + loopVarName + "' non déclarée.");
    //     }
        
    //     // Le deuxième enfant est le corps de la boucle, qui contient les commandes
    //     CommonTree commands = (CommonTree) tree.getChild(1);
    
    //     // Visiter les commandes qui peuvent utiliser cette variable
    //     symbolTable.enterScope();
        
    //     // Nous ajoutons Result dans le scope local de la boucle
    //     // (Il est déclaré dans les commandes du FOR sous LET)
    //     CommonTree letNode = (CommonTree) commands.getChild(0);  // Le noeud LET
    //     CommonTree varsNode = (CommonTree) letNode.getChild(0);  // Le noeud VARS dans LET
    //     for (int i = 0; i < varsNode.getChildCount(); i++) {
    //         String varName = varsNode.getChild(i).getText();
    //         if (!symbolTable.isSymbolInCurrentScope(varName)) {
    //             symbolTable.addSymbol(varName, "variable");
    //         }
    //     }
    
    //     // Visiter les commandes à l'intérieur du FOR (dans COMMANDS)
    //     visit(commands);
        
    //     symbolTable.exitScope();
    // }

    // Vérification des appels de fonction
    private void visitFunctionCall(CommonTree tree) {
        String functionName = tree.getChild(0).getText(); // Récupérer le nom de la fonction
        // Vérifier si la fonction est déclarée
        if (symbolTable.resolveSymbol(functionName) == null) {
            throw new RuntimeException("Erreur sémantique : Fonction '" + functionName + "' non déclarée.");
        }
    }

    // Vérification des appels de variable
    private void visitVariable(CommonTree tree) {
        // On suppose que le noeud Variable contient le nom de la variable
        if (tree.getType() == WhileLexer.Variable) {
            String variableName = tree.getText(); // Récupérer le nom de la variable
            // Vérifier si la variable est déclarée
            if (!symbolTable.isSymbolDeclared(variableName)) {
                throw new RuntimeException("Erreur sémantique : Variable '" + variableName + "' non déclarée.");
            }
        }
    }

    private void visitChildren(CommonTree tree) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            visit((CommonTree) tree.getChild(i));
        }
    }
}
