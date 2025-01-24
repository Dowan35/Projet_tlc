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

    private void translateNode(Tree node, List<String> result) {
        if (node == null) {
            return;
        }

        switch (node.getText()) {
            case "PROGRAM":
                forEachChild(node, child -> translateNode(child, result));
                break;

            case "FUNCTION":
                String functionName = getChildText(node, 0);
                result.add("function " + functionName + ":");
                translateNode(getChild(node, 1), result); // Inputs
                translateNode(getChild(node, 2), result); // Commands
                translateNode(getChild(node, 3), result); // Outputs
                result.add("end_function");
                break;

            case "INPUTS":
                forEachChild(node, child -> {
                    String readVar = child.getText();
                    result.add("read " + readVar);
                });
                break;

            case "OUTPUTS":
                forEachChild(node, child -> {
                    String writeVar = child.getText();
                    if (!writeVar.isEmpty()) {
                        result.add("write " + writeVar);
                    }
                });
                break;

            case "COMMANDS":
                forEachChild(node, child -> translateNode(child, result));
                break;

            case "VARS":
                List<String> vars = new ArrayList<>();
                forEachChild(node, child -> {
                    String varName = child.getText();
                    if (!varName.isEmpty()) {
                        vars.add(varName);
                    }
                });
                if (!vars.isEmpty()) {
                    result.add("VARS = " + String.join(", ", vars));
                }
                break;

            default:
                translateExpression(node, result);
                break;
        }
    }

    // Méthode pour traduire une expression en code trois adresses
    private String translateExpression(Tree node, List<String> result) {
        if (node == null) return "";
    
        try {
            switch (node.getText()) {
                case "NUMBER":
                case "Symbol":
                case "Variable":
                    return node.getText();
    
                case "LET":
                    String leftVar = getChildText(node, 0);
                    String rightExpr = translateExpression(getChild(node, 1), result);
                    result.add(leftVar + " = " + rightExpr);
                    return leftVar;
    
                case "CONS":
                    String left = translateExpression(getChild(node, 0), result);
                    String right = translateExpression(getChild(node, 1), result);
                    if (left.isEmpty()) left = "NIL";
                    if (right.isEmpty()) right = "NIL";
                    String tempCons = generateTemp();
                    result.add(tempCons + " = CONS " + left + ", " + right);
                    result.add("Result = " + tempCons);
                    return tempCons;
    
                case "SYMB":
                    String functionName = getChildText(node, 0);
                    String tempCallResult = generateTemp();
                    result.add(tempCallResult + " = CALL " + functionName); // Appel de fonction
                    if (node.getChildCount() > 1) { // Vérifie s'il y a un second enfant
                        String resultVar = getChildText(node, 1);
                        if (!resultVar.isEmpty()) {
                            result.add(resultVar + " = " + tempCallResult); // Stocke le résultat dans une variable
                        }
                    }
                    return tempCallResult;
    
                case "IF":
                    String condition = translateExpression(getChild(node, 0), result);
                    String elseLabel = generateLabel("else");
                    String endLabel = generateLabel("end_if");
    
                    result.add("ifz " + condition + " goto " + elseLabel);
                    translateExpression(getChild(node, 1), result);
                    result.add("goto " + endLabel);
                    result.add(elseLabel + ":");
                    if (node.getChildCount() > 2) {
                        translateExpression(getChild(node, 2), result);
                    }
                    result.add(endLabel + ":");
                    return "";
    
                case "NIL":
                    return "NIL";
    
                case "WHILE":
                    String startLabel = generateLabel("while_start");
                    String endLabelWhile = generateLabel("while_end");
                    String whileCondition = translateExpression(getChild(node, 0), result);
    
                    result.add(startLabel + ":");
                    result.add("ifz " + whileCondition + " goto " + endLabelWhile);
                    translateExpression(getChild(node, 1), result);
                    result.add("goto " + startLabel);
                    result.add(endLabelWhile + ":");
                    return "";
    
                case "FOR":
                    String forVar = getChildText(node, 0);
                    String forCondition = generateTemp();
                    String forStartLabel = generateLabel("for_start");
                    String forEndLabel = generateLabel("for_end");
    
                    result.add(forVar + " = " + translateExpression(getChild(node, 1), result));
                    result.add(forStartLabel + ":");
                    result.add(forCondition + " = " + forVar + " <= 0");
                    result.add("ifz " + forCondition + " goto " + forEndLabel);
                    translateExpression(getChild(node, 2), result);
                    result.add(forVar + " = " + forVar + " + 1");
                    result.add("goto " + forStartLabel);
                    result.add(forEndLabel + ":");
                    return "";
    
                case "PLUS":
                case "MINUS":
                case "MULT":
                case "DIV":
                    String leftOp = translateExpression(getChild(node, 0), result);
                    String rightOp = translateExpression(getChild(node, 1), result);
                    String tempOp = generateTemp();
                    result.add(tempOp + " = " + leftOp + " " + getOperator(node.getText()) + " " + rightOp);
                    return tempOp;
    
                case "EXPRS":
                case "COMMANDS":
                    forEachChild(node, child -> translateExpression(child, result));
                    return "";
    
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
        return "R" + (tempCounter++);
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
