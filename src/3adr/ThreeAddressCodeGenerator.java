import org.antlr.runtime.tree.Tree;
import java.util.ArrayList;
import java.util.List;
import antlr.WhileLexer;

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
        switch (node.getType()) {
            case WhileLexer.PROGRAM:
            case WhileLexer.COMMANDS:
                for (int i = 0; i < node.getChildCount(); i++) {
                    translateNode(node.getChild(i), result);
                }
                break;

            case WhileLexer.READ:
                String readVar = node.getChild(0).getText();
                result.add("read " + readVar);
                break;

            case WhileLexer.WRITE:
                String writeVar = node.getChild(0).getText();
                result.add("write " + writeVar);
                break;

            case WhileLexer.ASSIGN:
                String leftVar = node.getChild(0).getText();
                String exprResult = translateExpression(node.getChild(1), result);
                result.add(leftVar + " = " + exprResult);
                break;

            case WhileLexer.IF:
                String condition = translateExpression(node.getChild(0), result);
                String elseLabel = generateLabel("else");
                String endLabel = generateLabel("end_if");

                result.add("ifz " + condition + " goto " + elseLabel);
                translateNode(node.getChild(1), result); // then branch
                result.add("goto " + endLabel);
                result.add(elseLabel + ":");
                if (node.getChildCount() > 2) {
                    translateNode(node.getChild(2), result); // else branch
                }
                result.add(endLabel + ":");
                break;

            case WhileLexer.WHILE:
                String startLabel = generateLabel("while_start");
                String endLabelWhile = generateLabel("while_end");
                String whileCondition = translateExpression(node.getChild(0), result);

                result.add(startLabel + ":");
                result.add("ifz " + whileCondition + " goto " + endLabelWhile);
                translateNode(node.getChild(1), result); // body
                result.add("goto " + startLabel);
                result.add(endLabelWhile + ":");
                break;

            case WhileLexer.FOR:
                String forVar = node.getChild(0).getText();
                String forCondition = generateTemp();
                String forStartLabel = generateLabel("for_start");
                String forEndLabel = generateLabel("for_end");

                result.add(forVar + " = " + translateExpression(node.getChild(0), result));
                result.add(forStartLabel + ":");
                result.add(forCondition + " = " + forVar + " <= 0");
                result.add("ifz " + forCondition + " goto " + forEndLabel);
                translateNode(node.getChild(1), result); // body
                result.add(forVar + " = " + forVar + "[1]");
                result.add("goto " + forStartLabel);
                result.add(forEndLabel + ":");
                break;

            default:
                throw new IllegalArgumentException("Unknown node type: " + node.getType());
        }
    }

    // Méthode pour traduire une expression en code trois adresses
    private String translateExpression(Tree node, List<String> result) {
        switch (node.getType()) {
            case WhileLexer.NUMBER:
                return node.getText();

            case WhileLexer.VARIABLE:
                return node.getText();

            case WhileLexer.PLUS:
            case WhileLexer.MINUS:
            case WhileLexer.MULT:
            case WhileLexer.DIV:
                String left = translateExpression(node.getChild(0), result);
                String right = translateExpression(node.getChild(1), result);
                String temp = generateTemp();
                result.add(temp + " = " + left + " " + getOperator(node.getType()) + " " + right);
                return temp;

            case WhileLexer.HD:
                String listHd = translateExpression(node.getChild(0), result);
                String tempHd = generateTemp();
                result.add(tempHd + " = " + listHd + "[0]");
                return tempHd;

            case WhileLexer.TL:
                String listTl = translateExpression(node.getChild(0), result);
                String tempTl = generateTemp();
                result.add(tempTl + " = " + listTl + "[1]");
                return tempTl;

            default:
                throw new IllegalArgumentException("Unknown expression type: " + node.getType());
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
    private String getOperator(int type) {
        switch (type) {
            case WhileLexer.PLUS: return "+";
            case WhileLexer.MINUS: return "-";
            case WhileLexer.MULT: return "*";
            case WhileLexer.DIV: return "/";
            default: throw new IllegalArgumentException("Unknown operator type: " + type);
        }
    }
}
