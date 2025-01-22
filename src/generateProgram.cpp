#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <algorithm> // Pour std::find et std::isspace
#include <set>

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

    std::set<std::string> declaredVariables; // Pour éviter les déclarations multiples
    std::set<std::string> labels;  // Pour garantir que les labels sont uniques

    // Génération du code C++
    outFile << "#include <iostream>\n";
    outFile << "int main() {\n";

    for (const std::string& line : code3Addresses) {
        // Traiter les labels
        if (line.find(":") != std::string::npos) {
            std::string label = trim(line.substr(0, line.find(":")));
            if (labels.find(label) == labels.end()) {
                labels.insert(label);
                outFile << "    " << label << ":\n";
            } else {
                std::cerr << "Erreur : le label '" << label << "' est déjà défini.\n";
                return;
            }
        }
        // Traiter les sauts conditionnels (if ... goto)
        else if (line.find("if") != std::string::npos) {
            size_t conditionStart = line.find("if") + 3;
            size_t gotoStart = line.find("goto");
            std::string condition = trim(line.substr(conditionStart, gotoStart - conditionStart));
            std::string label = trim(line.substr(gotoStart + 5));
            outFile << "    if (" << condition << ") goto " << label << ";\n";
        }
        // Traiter les sauts inconditionnels (goto)
        else if (line.find("goto") != std::string::npos) {
            std::string label = trim(line.substr(line.find("goto") + 5));
            outFile << "    goto " << label << ";\n";
        }
        // Traiter les affectations
        else if (line.find("=") != std::string::npos) {
            size_t equalPos = line.find("=");
            std::string left = trim(line.substr(0, equalPos));
            std::string right = trim(line.substr(equalPos + 1));

            // Déclarer la variable si elle n'est pas déjà déclarée
            if (declaredVariables.find(left) == declaredVariables.end()) {
                declaredVariables.insert(left);
                outFile << "    int " << left << " = " << right << ";\n";
            } else {
                outFile << "    " << left << " = " << right << ";\n";
            }
        }
    }

    outFile << "    return 0;\n";
    outFile << "}\n";
    outFile.close();

    std::cout << "Code C++ généré dans le fichier " << outputFilename << "." << std::endl;
}

int main() {
    // Exemple de code 3 adresses
    std::vector<std::string> code3Addresses = {
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

    // Générer le code C++ dans un fichier
    generateCppCode(code3Addresses, "GeneratedProgram.cpp");

    return 0;
}
