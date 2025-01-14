import java.util.*;

public class SymbolTable {
    private Map<String, String> globalSymbols; // Symboles globaux
    private Deque<Map<String, String>> scopes; // Pile de portées locales

    public SymbolTable() {
        globalSymbols = new HashMap<>();
        scopes = new ArrayDeque<>();
    }

    // Ajouter un symbole global
    public void addGlobalSymbol(String name, String type) {
        if (globalSymbols.containsKey(name)) {
            System.err.println("Erreur : Le symbole global '" + name + "' est déjà défini.");
        } else {
            globalSymbols.put(name, type);
        }
    }

    // Entrer dans un nouveau scope (créer une nouvelle map locale)
    public void enterScope() {
        scopes.push(new HashMap<>());
    }

    // Sortir du scope actuel
    public void exitScope() {
        if (scopes.isEmpty()) {
            System.err.println("Erreur : Aucun scope à quitter.");
        } else {
            scopes.pop();
        }
    }

    // Ajouter un symbole dans le scope courant
    public void addLocalSymbol(String name, String type) {
        if (scopes.isEmpty()) {
            System.err.println("Erreur : Aucun scope actif pour ajouter le symbole '" + name + "'.");
        } else {
            Map<String, String> currentScope = scopes.peek();
            if (currentScope.containsKey(name)) {
                System.err.println("Erreur : Le symbole local '" + name + "' est déjà défini dans le scope actuel.");
            } else {
                currentScope.put(name, type);
            }
        }
    }

    // Rechercher un symbole dans les scopes locaux, sinon dans les globaux
    public String lookupSymbol(String name) {
        // Vérifier les scopes locaux en commençant par le plus récent
        for (Map<String, String> scope : scopes) {
            if (scope.containsKey(name)) {
                return scope.get(name);
            }
        }
        // Vérifier les symboles globaux
        return globalSymbols.get(name);
    }

    // Afficher la table des symboles
    public void printTable() {
        System.out.println("Table des symboles globaux :");
        for (Map.Entry<String, String> entry : globalSymbols.entrySet()) {
            System.out.println("  " + entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nScopes locaux (du plus récent au plus ancien) :");
        int scopeLevel = scopes.size();
        for (Map<String, String> scope : scopes) {
            System.out.println("Scope niveau " + scopeLevel + ":");
            for (Map.Entry<String, String> entry : scope.entrySet()) {
                System.out.println("  " + entry.getKey() + " : " + entry.getValue());
            }
            scopeLevel--;
        }
    }
}
