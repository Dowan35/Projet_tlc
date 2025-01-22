#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <set>
#include <algorithm> // Pour std::find et std::isspace

std::string trim(const std::string& str) {
    size_t first = str.find_first_not_of(" \t");
    size_t last = str.find_last_not_of(" \t");
    if (first == std::string::npos || last == std::string::npos) {
        return ""; // La chaîne est entièrement vide ou composée d'espaces
    }
    return str.substr(first, last - first + 1);
}

void generateCppCode(const std::vector<std::string>& code3Addresses, const std::string& outputFilename) {
    std::ofstream outFile(outputFilename);
    if (!outFile) {
        std::cerr << "Erreur : impossible de créer le fichier de sortie." << std::endl;
        return;
    }

    std::set<std::string> declaredVariables; // Suivi des variables déclarées
    std::set<std::string> usedVariables;    // Suivi des variables utilisées mais non déclarées

    // Analyse préalable pour trouver toutes les variables
    for (const std::string& line : code3Addresses) {
        if (line.find("=") != std::string::npos) {
            size_t equalPos = line.find("=");
            std::string left = trim(line.substr(0, equalPos));
            std::string right = trim(line.substr(equalPos + 1));

            declaredVariables.insert(left);

            // Vérifier les variables dans l'expression de droite
            size_t pos = 0;
            while (pos < right.size()) {
                size_t start = right.find_first_not_of(" \t+-*/()", pos);
                if (start == std::string::npos) break;
                size_t end = right.find_first_of(" \t+-*/()", start);
                std::string variable = right.substr(start, end - start);
                if (!std::isdigit(variable[0])) {
                    usedVariables.insert(variable);
                }
                pos = end;
            }
        } else if (line.find("if") != std::string::npos) {
            size_t conditionStart = line.find("if") + 3;
            size_t gotoStart = line.find("goto");
            std::string condition = trim(line.substr(conditionStart, gotoStart - conditionStart));

            size_t operatorPos = condition.find_first_of("<>=!");
            if (operatorPos != std::string::npos) {
                std::string left = trim(condition.substr(0, operatorPos));
                std::string right = trim(condition.substr(operatorPos + 1));
                usedVariables.insert(left);
                usedVariables.insert(right);
            }
        }
    }

    // Enlever les variables déjà déclarées des variables utilisées
    for (const auto& var : declaredVariables) {
        usedVariables.erase(var);
    }

    // Génération du code C++
    outFile << "#include <iostream>\n";
    outFile << "int main() {\n";

    // Déclarer les variables nécessaires
    for (const auto& var : declaredVariables) {
        outFile << "    int " << var << ";\n";
    }
    for (const auto& var : usedVariables) {
        outFile << "    int " << var << ";\n";
    }

    // Générer le corps principal
    for (const std::string& line : code3Addresses) {
        if (line.find(":") != std::string::npos) {
            // Labels
            outFile << trim(line) << "\n";
        } else if (line.find("if") != std::string::npos) {
            // Saut conditionnel
            size_t conditionStart = line.find("if") + 3;
            size_t gotoStart = line.find("goto");
            std::string condition = trim(line.substr(conditionStart, gotoStart - conditionStart));
            std::string label = trim(line.substr(gotoStart + 5));
            outFile << "    if (" << condition << ") goto " << label << ";\n";
        } else if (line.find("goto") != std::string::npos) {
            // Saut inconditionnel
            std::string label = trim(line.substr(line.find("goto") + 5));
            outFile << "    goto " << label << ";\n";
        } else if (line.find("=") != std::string::npos) {
            // Assignation
            size_t equalPos = line.find("=");
            std::string left = trim(line.substr(0, equalPos));
            std::string right = trim(line.substr(equalPos + 1));
            outFile << "    " << left << " = " << right << ";\n";
        }
    }

    outFile << "    return 0;\n";
    outFile << "}\n";
    outFile.close();

    std::cout << "Code C++ généré dans le fichier " << outputFilename << "." << std::endl;
}

int main() {
    // Exemple 1 de code 3 adresses
    std::vector<std::string> code3Addresses1 = {
        "Result = Op1",          // Initialisation
        "Counter = Op2",         // Initialisation
        "L1:",                   // Label
        "if Counter <= 0 goto L2", // Condition
        "Result = Result + 1",   // Incrémentation
        "Counter = Counter - 1", // Décrémentation
        "goto L1",               // Boucle
        "L2:"                    // Label de sortie
    };

    // Exemple 2 de code 3 adresses
    std::vector<std::string> code3Addresses2 = {
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

    // Générer les deux fichiers pour tester
    generateCppCode(code3Addresses1, "GeneratedProgram1.cpp");
    generateCppCode(code3Addresses2, "GeneratedProgram2.cpp");

    return 0;
}
