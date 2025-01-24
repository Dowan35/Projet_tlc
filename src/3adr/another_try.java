import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.tree.Tree;

import antlr.WhileLexer;

public class another_try {

    private int tempCounter = 0; // Compteur pour les registres temporaires
    private int labelCounter = 0; // Compteur pour les étiquettes de branchement
    private final List<String> errors = new ArrayList<>();

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<String> getErrors() {
        return errors;
    }

    // Méthode principale pour transformer un AST en code 3 adresses
    public List<String> generateCode(Tree ast) {
        List<String> result = new ArrayList<>();
        translateNode(ast, result);
        return result;
    }

    private String translateNode(Tree tree, List<String> result) {
        if (tree == null) {
            return "";
        }

       try {
            switch (tree.getType()) {

                case WhileLexer.Variable:
                    return tree.getText();
                case WhileLexer.PROGRAM:
                    for (int i = 0; i < tree.getChildCount(); i++) {
                        translateNode(tree.getChild(i), result);
                    }
                    break;
                case WhileLexer.FUNCTION:
                    String functName = getChildText(tree, 0);
                    result.add("");//passage de ligne
                    result.add("function " + functName + ":");
                    translateNode(getChild(tree, 1), result); // Inputs
                    translateNode(getChild(tree, 2), result); // Commands
                    translateNode(getChild(tree, 3), result); // Outputs
                    result.add("end_function");
                    break;
                case WhileLexer.INPUTS:
                    forEachChild(tree, child -> {
                        String readVar = child.getText();
                        if (!readVar.isEmpty()) {
                            result.add("read " + readVar);//ajoute une ligne a chaque input
                        }   
                    });
                    break;
                case WhileLexer.OUTPUTS:
                    forEachChild(tree, child -> {
                        String writeVar = child.getText();
                        result.add("write " + writeVar);
                    });
                    break;
                case WhileLexer.COMMANDS:
                    forEachChild(tree, child -> translateNode(child, result));
                    break;
    
                case WhileLexer.LET:
                    Tree varsNode = tree.getChild(0);
                    Tree exprsNode = tree.getChild(1);
                    List<String> varName = new ArrayList<>();
                    List<String> exprs = new ArrayList<>();
                    
                    for (int i = 0; i < varsNode.getChildCount(); i++) {
                        varName.add(varsNode.getChild(i).getText());
                    }
                    for (int i = 0; i < exprsNode.getChildCount(); i++) {
                        exprs.add(translateExpression(getChild(tree, i), result));//on traduit les expressions
                    }
                    //si var1, var2, var3 := (1+2), (4+7)
                    if (varName.size() != exprs.size()){
                        throw new Error("Invalid expression: more variables than expressions");
                    }
                    for (int i = 0; i < varName.size(); i++){
                        result.add(varName.get(i) + " = " + exprs.get(i));
                    }

                    return "";
    
                case WhileLexer.CONS:
                    String left = translateNode(getChild(tree, 0), result);
                    String right = translateNode(getChild(tree, 1), result);
                    if (left.isEmpty()) left = "NIL";
                    if (right.isEmpty()) right = "NIL";
                    String tempCons = generateTemp();
                    result.add(tempCons + " = CONS " + left + ", " + right);
                    //result.add("Result = " + tempCons);
                    return tempCons;
    
                case WhileLexer.SYMB:
                    String functionName = getChildText(tree, 0);
                    String tempCallResult = generateTemp();
                    result.add(tempCallResult + " = CALL " + functionName); // Appel de fonction
                    if (tree.getChildCount() > 1) { // Vérifie s'il y a un second enfant
                        String resultVar = getChildText(tree, 1);
                        if (!resultVar.isEmpty()) {
                            result.add(resultVar + " = " + tempCallResult); // Stocke le résultat dans une variable
                        }
                    }
                    return tempCallResult;
    
                case WhileLexer.IF:
                    String condition = translateNode(getChild(tree, 0), result);
                    String elseLabel = generateLabel("else");
                    String endLabel = generateLabel("end_if");
    
                    result.add("ifz " + condition + " goto " + elseLabel);
                    translateNode(getChild(tree, 1), result);
                    result.add("goto " + endLabel);
                    result.add(elseLabel + ":");
                    if (tree.getChildCount() > 2) {
                        translateNode(getChild(tree, 2), result);
                    }
                    result.add(endLabel + ":");
                    break;
    
                case WhileLexer.NIL:
                    return "NIL";
    
                case WhileLexer.WHILE:
                    String startLabel = generateLabel("while_start");
                    String endLabelWhile = generateLabel("while_end");
                    String whileCondition = translateNode(getChild(tree, 0), result);
    
                    result.add(startLabel + ":");
                    result.add("ifz " + whileCondition + " goto " + endLabelWhile);
                    translateNode(getChild(tree, 1), result);
                    result.add("goto " + startLabel);
                    result.add(endLabelWhile + ":");
                    break;
    
                case WhileLexer.FOR:
                    String forVar = getChildText(tree, 0);
                    String forCondition = generateTemp();
                    String forStartLabel = generateLabel("for_start");
                    String forEndLabel = generateLabel("for_end");
    
                    result.add(forVar + " = " + translateNode(getChild(tree, 1), result));
                    result.add(forStartLabel + ":");
                    result.add(forCondition + " = " + forVar + " <= 0");
                    result.add("ifz " + forCondition + " goto " + forEndLabel);
                    translateNode(getChild(tree, 2), result);
                    result.add(forVar + " = " + forVar + " + 1");
                    result.add("goto " + forStartLabel);
                    result.add(forEndLabel + ":");
                    break;
    
                default:
                    break;
                    //throw new IllegalArgumentException("Unknown expression type: " + tree.getText());
            }
        } catch (RuntimeException e) {
            errors.add(e.getMessage());
        }
        
        return "";   
    }

     // Méthode pour traduire une expression en code trois adresses
     private String translateExpression(Tree tree, List<String> result) {
        if (tree == null) return "";
    
        try {
            switch (tree.getType()) {
                case WhileLexer.NIL:
                    return "NIL";
    
                case WhileLexer.Variable:
                    return tree.getText();
    
                case WhileLexer.CONS: {
                    String left = translateExpression(getChild(tree, 0), result);
                    String right = translateExpression(getChild(tree, 1), result);
                    if (left.isEmpty()) left = "NIL";
                    if (right.isEmpty()) right = "NIL";
                    String tempCons = generateTemp();
                    result.add(tempCons + " = CONS " + left + ", " + right);
                    return tempCons;
                }
    
                case WhileLexer.LIST: {
                    StringBuilder listBuilder = new StringBuilder();
                    for (int i = 0; i < tree.getChildCount(); i++) {
                        String childExpr = translateExpression(getChild(tree, i), result);
                        listBuilder.append(childExpr).append(", ");
                    }
                    String tempList = generateTemp();
                    result.add(tempList + " = LIST " + listBuilder.toString().replaceAll(", $", ""));
                    return tempList;
                }
    
                case WhileLexer.HD: {
                    String childExpr = translateExpression(getChild(tree, 0), result);
                    String tempHd = generateTemp();
                    result.add(tempHd + " = HD " + childExpr);
                    return tempHd;
                }
    
                case WhileLexer.TL: {
                    String childExpr = translateExpression(getChild(tree, 0), result);
                    String tempTl = generateTemp();
                    result.add(tempTl + " = TL " + childExpr);
                    return tempTl;
                }
    
                case WhileLexer.SYMB: {
                    String functionName = tree.getText();
                    String tempSymbol = generateTemp();
                    result.add(tempSymbol + " = CALL " + functionName);
                    return tempSymbol;
                }
    
                default:
                    throw new RuntimeException("Unsupported expression type: " + tree.getText());
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error processing expression node: " + tree.getText(), e);
        }
    }
    
    

    // Méthodes utilitaires pour gérer les enfants des nœuds
    private Tree getChild(Tree tree, int index) {
        if (index < 0 || index >= tree.getChildCount()) {
            throw new IllegalArgumentException("Invalid child index: " + index);
        }
        return tree.getChild(index);
    }

    private String getChildText(Tree tree, int index) {
        return getChild(tree, index).getText();
    }

    private void forEachChild(Tree tree, java.util.function.Consumer<Tree> action) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            action.accept(getChild(tree, i));
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


}
