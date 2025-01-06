package grammaire;

import java.io.*;
import java.util.*;

class SymbolTable {
    static class Identifier {
        String name, classe, type;
        int address, complement;

        public Identifier(String name, String classe, String type, int address, int complement) {
            this.name = name;
            this.classe = classe;
            this.type = type;
            this.address = address;
            this.complement = complement;
        }

        @Override
        public String toString() {
            return String.format("%-10s | %-6s | %-8s | %-7d | %-5d", name, classe, type, address, complement);
        }
    }

    private List<Identifier> globalTable = new ArrayList<>();
    private List<Identifier> localTable = new ArrayList<>();
    private int globalAddress = 0, localAddress = 0;
    private boolean inFunction = false;

    public void addIdentifier(String name, String classe, String type, int complement) {
        Identifier id = new Identifier(name, classe, type,
                inFunction ? localAddress++ : globalAddress++, complement);
        if (inFunction)
            localTable.add(id);
        else
            globalTable.add(id);
    }

    public void enterFunction(String name, int paramCount) {
        addIdentifier(name, "FONC", "-", paramCount);
        inFunction = true;
        localAddress = 0; // Reset local address for the function
    }

    public void exitFunction() {
        inFunction = false;
        localTable.clear();
    }

    public void displaySymbolTable() {
        System.out.println("Table des symboles globale :");
        System.out.println("identifiant | classe | type     | adresse | comp.");
        for (Identifier id : globalTable)
            System.out.println(id);

        System.out.println("\nTable des symboles locale :");
        System.out.println("identifiant | classe | type     | adresse | comp.");
        for (Identifier id : localTable)
            System.out.println(id);
    }
}

public class Main {
    public static void main(String[] args) {
        SymbolTable symbolTable = new SymbolTable();

        try {
            File file = new File(
                    "C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\codeTest.while");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("function")) {
                    String functionName = line.split(" ")[1].split(":")[0];
                    symbolTable.enterFunction(functionName, 0);
                } else if (line.startsWith("read")) {
                    String[] vars = line.replace("read", "").trim().split(",");
                    for (String var : vars)
                        symbolTable.addIdentifier(var.trim(), "ARG", "entier", 0);
                } else if (line.startsWith("write")) {
                    String[] vars = line.replace("write", "").trim().split(",");
                    for (String var : vars)
                        symbolTable.addIdentifier(var.trim(), "OUT", "entier", 0);
                } else if (line.contains(":=")) {
                    String var = line.split(":=")[0].trim();
                    symbolTable.addIdentifier(var, "LOC", "entier", 0);
                } else if (line.startsWith("fi") || line.startsWith("od")) {
                    symbolTable.exitFunction();
                }
            }
            reader.close();
            symbolTable.displaySymbolTable();
        } catch (IOException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
