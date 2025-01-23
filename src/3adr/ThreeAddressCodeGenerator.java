import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime.tree.Tree;

public class ThreeAddressCodeGenerator {

    private int tempCounter = 0; // Compteur pour les registres temporaires
    private int labelCounter = 0; // Compteur pour les étiquettes de branchement

    // Méthode principale pour transformer un AST en code 3 adresses
    public List<String> generateCode(Tree ast) {
        List<String> result = new ArrayList<>();
        translateNode(ast, result);
        return result;
    }

    // Méthode récursive pour traduire un nœud de l'AST
    private void translateNode(Tree node, List<String> result) {
        if (node == null) return;

        try {
            switch (node.getText()) {
                case "PROGRAM":
                    forEachChild(node, child -> translateNode(child, result));
                    break;

                case "FUNCTION":
                    String functionName = getChildText(node, 0); // Nom de la fonction

                    result.add("function " + functionName + ":");

                    // Traiter les sous-nœuds : Inputs, Commands, Outputs
                    Tree inputs = getChild(node, 1);
                    Tree commands = getChild(node, 2);
                    Tree outputs = getChild(node, 3);

                    translateNode(inputs, result);
                    translateNode(commands, result);
                    translateNode(outputs, result);

                    result.add("end_function");
                    break;

                case "INPUTS":
                    forEachChild(node, child -> {
                        String readVar = child.getText();
                        result.add("read " + readVar);
                    });
                    break;

                case "COMMANDS":
                    forEachChild(node, child -> translateNode(child, result));
                    break;

                case "OUTPUTS":
                    forEachChild(node, child -> {
                        String writeVar = child.getText();
                        result.add("write " + writeVar);
                    });
                    break;

                case "LET":
                    String leftVar = getChildText(node, 0);
                    String exprResult = translateExpression(getChild(node, 1), result);
                    result.add(leftVar + " = " + exprResult);
                    break;

                case "IF":
                    String condition = translateExpression(getChild(node, 0), result);
                    String elseLabel = generateLabel("else");
                    String endLabel = generateLabel("end_if");

                    result.add("ifz " + condition + " goto " + elseLabel);
                    translateNode(getChild(node, 1), result); // then branch
                    result.add("goto " + endLabel);
                    result.add(elseLabel + ":");
                    if (node.getChildCount() > 2) {
                        translateNode(getChild(node, 2), result); // else branch
                    }
                    result.add(endLabel + ":");
                    break;

                case "WHILE":
                    String startLabel = generateLabel("while_start");
                    String endLabelWhile = generateLabel("while_end");
                    String whileCondition = translateExpression(getChild(node, 0), result);

                    result.add(startLabel + ":");
                    result.add("ifz " + whileCondition + " goto " + endLabelWhile);
                    translateNode(getChild(node, 1), result); // body
                    result.add("goto " + startLabel);
                    result.add(endLabelWhile + ":");
                    break;

                case "FOR":
                    String forVar = getChildText(node, 0);
                    String forCondition = generateTemp();
                    String forStartLabel = generateLabel("for_start");
                    String forEndLabel = generateLabel("for_end");

                    result.add(forVar + " = " + translateExpression(getChild(node, 0), result));
                    result.add(forStartLabel + ":");
                    result.add(forCondition + " = " + forVar + " <= 0");
                    result.add("ifz " + forCondition + " goto " + forEndLabel);
                    translateNode(getChild(node, 1), result); // body
                    result.add(forVar + " = " + forVar + " + 1");
                    result.add("goto " + forStartLabel);
                    result.add(forEndLabel + ":");
                    break;

                case "EXPRS": // Correction : ne pas retourner, juste traiter les enfants
                    forEachChild(node, child -> translateExpression(child, result)); 
                    break;

                case "NOP":
                    // Pas d'action à effectuer pour NOP
                    break;

                default:
                    throw new IllegalArgumentException("Unknown node type: " + node.getText());
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error processing node: " + node.getText(), e);
        }
    }

    // Méthode pour traduire une expression en code trois adresses
    private String translateExpression(Tree node, List<String> result) {
        if (node == null) return "";

        try {
            switch (node.getText()) {
                case "NUMBER":
                case "SYMB":
                case "Symbol":
                    return node.getText();

                case "Variable":
                    return node.getText();

                case "CONS":
                    String left = translateExpression(getChild(node, 0), result);
                    String right = translateExpression(getChild(node, 1), result);
                    String tempCons = generateTemp();
                    result.add(tempCons + " = " + left + " : " + right);
                    return tempCons;

                case "HD":
                    String listHd = translateExpression(getChild(node, 0), result);
                    String tempHd = generateTemp();
                    result.add(tempHd + " = " + listHd + "[0]");
                    return tempHd;

                case "TL":
                    String listTl = translateExpression(getChild(node, 0), result);
                    String tempTl = generateTemp();
                    result.add(tempTl + " = " + listTl + "[1]");
                    return tempTl;

                case "PLUS":
                case "MINUS":
                case "MULT":
                case "DIV":
                    String leftOp = translateExpression(getChild(node, 0), result);
                    String rightOp = translateExpression(getChild(node, 1), result);
                    String tempOp = generateTemp();
                    result.add(tempOp + " = " + leftOp + " " + getOperator(node.getText()) + " " + rightOp);
                    return tempOp;

                default:
                    throw new IllegalArgumentException("Unknown expression type: " + node.getText());
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error processing expression node: " + node.getText(), e);
        }
    }

    // Méthodes utilitaires pour gérer les enfants des nœuds
    private Tree getChild(Tree node, int index) {
        if (index < 0 || index >= node.getChildCount()) {
            throw new IllegalArgumentException("Invalid child index: " + index);
        }
        return node.getChild(index);
    }

    private String getChildText(Tree node, int index) {
        return getChild(node, index).getText();
    }

    private void forEachChild(Tree node, java.util.function.Consumer<Tree> action) {
        for (int i = 0; i < node.getChildCount(); i++) {
            action.accept(getChild(node, i));
        }
    }

    // Méthode pour générer un nom de registre temporaire
    private String generateTemp() {
        return "R_" + (tempCounter++);
    }

    // Méthode pour générer une étiquette
    private String generateLabel(String prefix) {
        return prefix + "_" + (labelCounter++);
    }

    // Méthode pour obtenir le symbole d'une opération
    private String getOperator(String type) {
        switch (type) {
            case "PLUS": return "+";
            case "MINUS": return "-";
            case "MULT": return "*";
            case "DIV": return "/";
            default: throw new IllegalArgumentException("Unknown operator type: " + type);
        }
    }
}
