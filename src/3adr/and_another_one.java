import org.antlr.runtime.tree.*;
import java.util.*;

public class and_another_one {
    private int tempCounter = 0;
    private StringBuilder code = new StringBuilder();

    public String generateThreeAddressCode(CommonTree ast) {
        for (Object child : ast.getChildren()) {
            CommonTree node = (CommonTree) child;
            if (node.getText().equals("FUNCTION")) {
                generateFunction(node);
            }
        }
        return code.toString();
    }

    private void generateFunction(CommonTree node) {
        String functionName = node.getChild(0).getText();
        code.append("function ").append(functionName).append(":\n");

        CommonTree commandsNode = (CommonTree) node.getChild(2);
        generateCommands(commandsNode);

        CommonTree outputsNode = (CommonTree) node.getChild(3);
        generateOutputs(outputsNode);

        code.append("end_function\n\n");
    }

    private void generateCommands(CommonTree node) {
        for (Object child : node.getChildren()) {
            CommonTree command = (CommonTree) child;
            switch (command.getText()) {
                case "NOP":
                    break;
                case "LET":
                    generateLet(command);
                    break;
                case "IF":
                    generateIf(command);
                    break;
                case "WHILE":
                    generateWhile(command);
                    break;
                case "FOR":
                    generateFor(command);
                    break;
                case "FOREACH":
                    generateForeach(command);
                    break;
                default:
                    throw new RuntimeException("Unknown command: " + command.getText());
            }
        }
    }

    private void generateLet(CommonTree node) {
        CommonTree varsNode = (CommonTree) node.getChild(0);
        CommonTree exprsNode = (CommonTree) node.getChild(1);

        List<String> vars = extractVariables(varsNode);
        List<String> exprs = generateExpressions(exprsNode);

        for (int i = 0; i < vars.size(); i++) {
            code.append(vars.get(i)).append(" = ").append(exprs.get(i)).append("\n");
        }
    }

    private void generateIf(CommonTree node) {
        String condition = generateExpression((CommonTree) node.getChild(0));
        code.append("if ").append(condition).append(" then\n");

        CommonTree thenCommands = (CommonTree) node.getChild(1);
        generateCommands(thenCommands);

        if (node.getChildCount() > 2) {
            code.append("else\n");
            CommonTree elseCommands = (CommonTree) node.getChild(2);
            generateCommands(elseCommands);
        }

        code.append("fi\n");
    }

    private void generateWhile(CommonTree node) {
        String condition = generateExpression((CommonTree) node.getChild(0));
        code.append("while ").append(condition).append(" do\n");

        CommonTree commandsNode = (CommonTree) node.getChild(1);
        generateCommands(commandsNode);

        code.append("od\n");
    }

    private void generateFor(CommonTree node) {
        String iterator = generateExpression((CommonTree) node.getChild(0));
        code.append("for ").append(iterator).append(" do\n");

        CommonTree commandsNode = (CommonTree) node.getChild(1);
        generateCommands(commandsNode);

        code.append("od\n");
    }

    private void generateForeach(CommonTree node) {
        String variable = node.getChild(0).getText();
        String collection = generateExpression((CommonTree) node.getChild(1));
        code.append("foreach ").append(variable).append(" in ").append(collection).append(" do\n");

        CommonTree commandsNode = (CommonTree) node.getChild(2);
        generateCommands(commandsNode);

        code.append("od\n");
    }

    private void generateOutputs(CommonTree node) {
        for (Object child : node.getChildren()) {
            String output = ((CommonTree) child).getText();
            code.append("write ").append(output).append("\n");
        }
    }

    private List<String> generateExpressions(CommonTree node) {
        List<String> expressions = new ArrayList<>();
        for (Object child : node.getChildren()) {
            expressions.add(generateExpression((CommonTree) child));
        }
        return expressions;
    }

    private String generateExpression(CommonTree node) {
        switch (node.getText()) {
            case "CONS": {
                String left = generateExpression((CommonTree) node.getChild(0));
                String right = generateExpression((CommonTree) node.getChild(1));
                String temp = newTemp();
                code.append(temp).append(" = (cons ").append(left).append(" ").append(right).append(")\n");
                return temp;
            }
            case "NIL":
                return "nil";
            case "SYMB":
                return node.getChild(0).getText();
            default:
                return node.getText();
        }
    }

    private List<String> extractVariables(CommonTree node) {
        List<String> vars = new ArrayList<>();
        for (Object child : node.getChildren()) {
            vars.add(((CommonTree) child).getText());
        }
        return vars;
    }

    private String newTemp() {
        return "R" + tempCounter++;
    }

    public List<String> generateCode(Tree ast) {
        // Exemple : Chargez votre AST et utilisez cet outil
        and_another_one generator = new and_another_one();
        String threeAddressCode = generator.generateThreeAddressCode((CommonTree) ast);
        System.out.println(threeAddressCode);
        return new ArrayList<>();
    }

}
