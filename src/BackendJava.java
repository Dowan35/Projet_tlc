import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BackendJava {
    public static void main(String[] args) {
        // Exemple générique de code 3 adresses
        String[] code3Adresses = {
            "x = 10",               // Assignation
            "y = 5",                // Assignation
            "L1:",                  // Label
            "t1 = x - y",           // Calcul
            "if t1 <= 0 goto L2",   // Saut conditionnel
            "x = x - 1",            // Affectation
            "goto L1",              // Saut inconditionnel
            "L2:",                  // Label
            "result = x"            // Affectation finale
        };

        // Générer le code Java
        String javaCode = generateJavaCode(code3Adresses);

        // Écrire le code Java dans un fichier
        try (FileWriter writer = new FileWriter("GeneratedProgram.java")) {
            writer.write(javaCode);
            System.out.println("Code Java généré avec succès !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour générer le code Java à partir du code 3 adresses
    public static String generateJavaCode(String[] code3Adresses) {
        StringBuilder javaCode = new StringBuilder();
    
        // Début de la classe et de la méthode main
        javaCode.append("public class GeneratedProgram {\n");
        javaCode.append("    public static void main(String[] args) {\n");
    
        // Liste pour suivre les déclarations de variables
        List<String> declaredVariables = new ArrayList<>();
        boolean insideLoop = false; // Indique si nous sommes dans un `while (true)`
    
        // Traduire chaque instruction du code 3 adresses
        for (int i = 0; i < code3Adresses.length; i++) {
            String line = code3Adresses[i].trim();
    
            if (line.endsWith(":")) {
                // Gérer les labels avec des boucles while
                if (insideLoop) {
                    javaCode.append("        }\n"); // Fermer la boucle précédente
                }
                javaCode.append("        // ").append(line).append("\n");
    
                // Ajouter un `while (true)` uniquement si ce n'est pas le dernier label
                if (i < code3Adresses.length - 1) {
                    javaCode.append("        while (true) {\n");
                    insideLoop = true;
                } else {
                    insideLoop = false; // Pas de boucle pour le dernier label
                }
    
            } else if (line.startsWith("if")) {
                // Gérer les sauts conditionnels
                String condition = line.substring(3, line.indexOf("goto")).trim();
                String label = line.substring(line.indexOf("goto") + 5).trim();
    
                // Ajouter une condition avec un `break` pour simuler un GOTO
                javaCode.append("            if (").append(condition).append(") {\n");
                javaCode.append("                break; // GOTO ").append(label).append("\n");
                javaCode.append("            }\n");
    
            } else if (line.startsWith("goto")) {
                // Gérer les sauts inconditionnels
                String label = line.substring(5).trim();
                javaCode.append("            break; // GOTO ").append(label).append("\n");
    
            } else if (line.contains("=")) {
                // Gérer les affectations
                String[] parts = line.split("=");
                String left = parts[0].trim();
                String right = parts[1].trim();
    
                // Déclarer la variable si elle ne l'est pas encore
                if (!declaredVariables.contains(left)) {
                    declaredVariables.add(left);
                    javaCode.append("            int ").append(left).append(" = ").append(right).append(";\n");
                } else {
                    javaCode.append("            ").append(left).append(" = ").append(right).append(";\n");
                }
            }
        }
    
        // Fermer la dernière boucle si elle existe
        if (insideLoop) {
            javaCode.append("        }\n");
        }
    
        // Fin de la méthode et de la classe
        javaCode.append("        System.out.println(\"Programme terminé.\");\n");
        javaCode.append("    }\n");
        javaCode.append("}\n");
    
        return javaCode.toString();
    }
    
    
}
