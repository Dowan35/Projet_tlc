import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
    private final Stack<Map<String, String>> scopes = new Stack<>();
    private SymbolTable parent;  // Ajouter un parent pour gérer l'héritage des scopes

    // Initialisation du scope global
    public SymbolTable() {
        enterScope(); // Crée un scope global au début
    }

    // Entrer dans un nouveau scope
    public void enterScope() {
        scopes.push(new HashMap<>());
    }

    // Quitter un scope
    public void exitScope() {
        if (scopes.isEmpty()) {
            throw new RuntimeException("Erreur interne : impossible de quitter un scope inexistant.");
        }
        scopes.pop();
    }

    // Ajouter un symbole dans le scope courant
    public void addSymbol(String name, String type) {
        Map<String, String> currentScope = scopes.peek();
        if (currentScope.containsKey(name)) {
            throw new RuntimeException("Erreur sémantique : Variable ou fonction '" + name + "' déjà déclarée dans le scope actuel.");
        }
        currentScope.put(name, type);
    }

    // Résoudre un symbole dans tous les scopes (y compris parents)
    public String resolveSymbol(String name) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            Map<String, String> scope = scopes.get(i);
            if (scope.containsKey(name)) {
                return scope.get(name);
            }
        }
        if (parent != null) {
            return parent.resolveSymbol(name);  // Vérification dans le scope parent
        }
        throw new RuntimeException("Erreur sémantique : Variable ou fonction '" + name + "' non déclarée.");
    }

    // Vérifier si un symbole est défini dans le scope courant
    public boolean isSymbolInCurrentScope(String name) {
        return scopes.peek().containsKey(name);
    }

    // Vérifier si un symbole est déclaré dans la table actuelle ou dans les scopes parent
    public boolean isSymbolDeclared(String symbol) {
        if (isSymbolInCurrentScope(symbol)) {
            return true;
        }
        if (parent != null) {
            return parent.isSymbolDeclared(symbol);
        }
        return false;
    }

    // Créer un scope enfant
    public SymbolTable createChildScope() {
        SymbolTable childScope = new SymbolTable();
        childScope.parent = this;  // Relier l'enfant à son parent
        return childScope;
    }
    
    // Méthode pour afficher la table des symboles et leurs scopes imbriqués
    public void printSymbolTable() {
        System.out.println("Table des symboles avec scopes imbriqués :");
        int depth = 1;
        for (Map<String, String> scope : scopes) {
            System.out.println("  Scope niveau " + depth + ":");
            for (Map.Entry<String, String> entry : scope.entrySet()) {
                System.out.println("    " + entry.getKey() + " : " + entry.getValue());
            }
            depth++;
        }
    }
}
