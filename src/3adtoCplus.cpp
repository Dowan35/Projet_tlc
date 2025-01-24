#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <string>
#include <cctype>
#include <algorithm>

//pour le lancer, mettre en premier argument le fichier 3a à traduire puis en deuxième argument le nom du fichier C++ qui sera généré

// Fonction pour convertir une chaîne en minuscules
void toLowerCase(std::string &str) {
    std::transform(str.begin(), str.end(), str.begin(), ::tolower);
}

// Fonction pour vérifier si une variable a déjà été déclarée
bool isDeclared(const std::string &varName, const std::vector<std::string> &declaredVars) {
    return std::find(declaredVars.begin(), declaredVars.end(), varName) != declaredVars.end();
}

// Fonction pour supprimer les espaces en début et fin de chaîne
void trim(std::string &str) {
    str.erase(str.begin(), std::find_if(str.begin(), str.end(), [](unsigned char ch) {
        return !std::isspace(ch);
    }));
    str.erase(std::find_if(str.rbegin(), str.rend(), [](unsigned char ch) {
        return !std::isspace(ch);
    }).base(), str.end());
}

// Fonction pour remplacer "nil" par "NULL"
void replaceNil(std::string &str) {
    size_t pos = str.find("nil");
    if (pos != std::string::npos) {
        str.replace(pos, 3, "NULL");
    }
}

// Fonction principale de traduction
void translate3AtoC(const std::string &inputFile, const std::string &outputFile) {
    std::ifstream inFile(inputFile);
    std::ofstream outFile(outputFile);

    if (!inFile || !outFile) {
        std::cerr << "Erreur d'ouverture de fichier" << std::endl;
        exit(EXIT_FAILURE);
    }

    std::string line;
    bool insideFunction = false; // Indique si on est à l'intérieur d'une fonction
    bool insideLabel = false;    // Indique si on est dans un label

    // Liste des variables déjà déclarées
    std::vector<std::string> declaredVars;
    outFile << "#include <iostream>\n";
    outFile << "using namespace std;\n";

    while (std::getline(inFile, line)) {
        // Vérifier si la ligne commence par FUNCTION
        if (line.substr(0, 8) == "FUNCTION") {
            std::string funcName;
            std::string params;

            // Réinitialiser les variables déclarées à l'entrée d'une nouvelle fonction
            declaredVars.clear();

            // Trouver les parenthèses pour extraire les informations
            size_t start = line.find('(');
            size_t end = line.find(')');

            if (start != std::string::npos && end != std::string::npos && end > start) {
                // Extraire le nom de la fonction
                funcName = line.substr(9, start - 9);

                // Extraire les paramètres entre les parenthèses
                params = line.substr(start + 1, end - start - 1);

                // Convertir en minuscules le nom de la fonction (optionnel)
                toLowerCase(funcName);

                // Commencer la déclaration de la fonction en C++
                outFile << "int " << funcName << "(";

                // Traiter les paramètres séparés par des espaces
                std::istringstream paramStream(params);
                std::string param;
                while (paramStream >> param) {
                    outFile << "int " << param;

                    // Ajouter les paramètres à la liste des variables déclarées
                    declaredVars.push_back(param);

                    if (paramStream.peek() != EOF) {
                        outFile << ", ";
                    }
                }
                outFile << ") {\n";
                insideFunction = true; // On est à l'intérieur d'une fonction
            }
        }
        // Vérifier si la ligne est START_FUNC
        else if (line.substr(0, 10) == "START_FUNC") {
            // Ignorer cette ligne
            continue;
        }
        // Vérifier si la ligne est END_FUNC
        else if (line.substr(0, 8) == "END_FUNC") {
            outFile << "}\n";
            insideFunction = false; // Fin de la fonction
        }
        // Vérifier les labels (e.g., FOR_label_0:)
        else if (line.find(':') != std::string::npos) {
            std::string label = line.substr(0, line.find(':'));
            outFile << label << ":\n";
            insideLabel = true; // Indiquer que nous sommes dans un label
        }
        else if (line.substr(0, 8) == "IFZ  not") {
            std::string condition, targetLabel;
            std::istringstream iss(line.substr(8));
            iss >> condition >> targetLabel >> targetLabel;
            outFile << "    if (" << condition << " != 0) goto " << targetLabel << ";\n";
        }
        else if (line.substr(0, 3) == "IFZ") {
            std::string condition, targetLabel;
            std::istringstream iss(line.substr(3));
            iss >> condition >> targetLabel >> targetLabel;
            outFile << "    if (" << condition << " == 0) goto " << targetLabel << ";\n";
        }
        // Vérifier les sauts (e.g., GOTO FOR_label_0)
        else if (line.substr(0, 4) == "GOTO") {
            std::string targetLabel;
            std::istringstream iss(line.substr(4));
            iss >> targetLabel;
            outFile << "    goto " << targetLabel << ";\n";
        }
        // Vérifier et gérer les appels à TL (e.g., R3 = TL R2)
        else if (line.find("TL") != std::string::npos) {
            std::string left, right;
            std::istringstream iss(line);
            iss >> left >> right >> right >> right;

            // Vérifier si la variable n'est pas déjà déclarée
            if (!isDeclared(left, declaredVars)) {
                if (insideLabel) {
                    // Séparer déclaration et assignation dans un label
                    outFile << "    int " << left << ";\n";
                    outFile << "    " << left << " = " << right << " - 1;\n";
                } else {
                    outFile << "    int " << left << " = " << right << " - 1;\n";
                }
                declaredVars.push_back(left);
            } else {
                outFile << "    " << left << " = " << right << " - 1;\n";
            }
        }
        else if (line.find("CONS") != std::string::npos) {
            std::string left, right, extra;
            std::istringstream iss(line);
            iss >> left >> right >> right >> right;

            size_t commaPos = line.find(',');
            if (commaPos != std::string::npos) {
                right = line.substr(line.find("CONS") + 5, commaPos - (line.find("CONS") + 5));
                extra = line.substr(commaPos + 1);
            } else {
                iss.clear();
                iss.str(line);
                iss >> left >> right >> right >> right;
            }

            replaceNil(left);
            replaceNil(right);
            replaceNil(extra);

            // Vérifier si la variable n'est pas déjà déclarée
            if (!isDeclared(left, declaredVars)) {
                if (insideLabel) {
                    // Séparer déclaration et assignation dans un label
                    if (right == "NULL" && extra == "NULL") {
                        outFile << "    int " << left << " = 1;\n";
                    } else if (right == "NULL") {
                        outFile << "    int " << left << " = " << extra << " + 1;\n";
                    } else {
                        outFile << "    int " << left << ";\n";
                        outFile << "    " << left << " = CONS(" << right << ", " << extra << ");\n";
                    }
                } else {
                    if (right == "NULL" && extra == "NULL") {
                        outFile << "    int " << left << " = 1;\n";
                    } else if (right == "NULL") {
                        outFile << "    int " << left << " = " << extra << " + 1;\n";
                    } else {
                        outFile << "    int " << left << " = CONS(" << right << ", " << extra << ");\n";
                    }
                }
                declaredVars.push_back(left);
            } else {
                outFile << "    " << left << " = CONS(" << right << ", " << extra << ");\n";
            }
        }
        // Vérifier les retours (e.g., RETURN R2)
        else if (line.substr(0, 6) == "RETURN") {
            std::string returnValue;
            std::istringstream iss(line.substr(6));
            iss >> returnValue;
            outFile << "    return " << returnValue << ";\n";
        }
        // Traiter les lignes contenant des assignations (e.g., R0 = Op1)
        else if (insideFunction && line.find('=') != std::string::npos) {
            std::string left, right;
            std::istringstream iss(line);
            iss >> left >> right >> right;

            // Vérifier si la partie droite contient des parenthèses (indique un appel de fonction)
            if (right.find('(') != std::string::npos) {
                if (!isDeclared(left, declaredVars)) {
                    outFile << "    int " << left << ";\n";
                    declaredVars.push_back(left);
                }
                outFile << "    " << left << " = " << right << ";\n";
            } else {
                if (!isDeclared(left, declaredVars) && !isDeclared(right, declaredVars)) {
                    if (right == "nil") {
                        outFile << "    int " << left << " = 0;\n";
                    } else {
                        outFile << "    int " << left << ";\n";
                        declaredVars.push_back(left);
                    }
                }

                // Vérifier si la variable à droite n'a jamais été déclarée
                if (!isDeclared(right, declaredVars) && right != "nil") {
                    if (right == "true") {
                        outFile << "    int " << right << " = 1;\n";
                        declaredVars.push_back(right);
                    } else if (right == "false" || right == "nil") {
                        outFile << "    int " << right << " = 0;\n";
                        declaredVars.push_back(right);
                    }
                } else if (right == "nil") {
                    right = "0";
                }

                // Vérifier si la variable à gauche n'a jamais été déclarée
                if (!isDeclared(left, declaredVars)) {
                    if (insideLabel) {
                        // Séparer déclaration et assignation dans un label
                        outFile << "    int " << left << ";\n";
                        outFile << "    " << left << " = " << right << ";\n";
                    } else {
                        outFile << "    int " << left << " = " << right << ";\n";
                    }
                    declaredVars.push_back(left);
                } else {
                    outFile << "    " << left << " = " << right << ";\n";
                }
            }
        }
    }

    inFile.close();
    outFile.close();
}

int main(int argc, char *argv[]) {
    // Vérifier si le nombre de paramètres est correct
    if (argc != 3) {
        std::cerr << "Usage: " << argv[0] << " <input_file.3a> <output_file.cpp>" << std::endl;
        return EXIT_FAILURE;
    }

    std::string inputFile = argv[1];
    std::string outputFile = argv[2];

    // Appeler la fonction de traduction
    translate3AtoC(inputFile, outputFile);

    std::cout << "Traduction terminée. Le code C++ a été généré dans " << outputFile << std::endl;

    return EXIT_SUCCESS;
}
