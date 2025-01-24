package optimization;
import java.util.*;

public class CodeOptimizer {
    public List<String> optimize(List<String> tacCode) { // input code as list of strings
        List<String> optimizedCode = new ArrayList<>();

        // Track variable definitions and values for optimizations
        Map<String, String> computedValues = new HashMap<>();
        Set<String> usedVariables = new HashSet<>();

        for (String line : tacCode) {
            String[] parts = line.split("=");
            if (parts.length == 2) {
                String target = parts[0].trim();
                String expression = parts[1].trim();

                // Perform constant folding
                String foldedExpression = constantFolding(expression, computedValues);
                computedValues.put(target, foldedExpression);

                // Check for common subexpression elimination
                if (!optimizedCode.contains(target + " = " + foldedExpression)) {
                    optimizedCode.add(target + " = " + foldedExpression);
                }
                usedVariables.add(target);
            } else if (!line.contains("=")) {
                // Assume it's a standalone operation like a print or return
                optimizedCode.add(line);
                extractUsedVariables(line, usedVariables);
            }
        }

        // Remove unused variable assignments (dead code elimination)
        optimizedCode.removeIf(line -> isDeadCode(line, usedVariables));

        return optimizedCode;
    }

    private String constantFolding(String expression, Map<String, String> computedValues) {
        // Replace variables with their computed values if available
        for (Map.Entry<String, String> entry : computedValues.entrySet()) {
            expression = expression.replace(entry.getKey(), entry.getValue());
        }

        // Evaluate constant expressions if possible
        try {
            if (expression.matches("\\d+ \\+ \\d+")) {
                String[] parts = expression.split("\\+");
                return Integer.toString(Integer.parseInt(parts[0].trim()) + Integer.parseInt(parts[1].trim()));
            }
        } catch (Exception e) {
            // Ignore errors in evaluation, keep the original expression
        }

        return expression;
    }

    private void extractUsedVariables(String line, Set<String> usedVariables) {
        // Extract variables used in operations like print or return
        String[] tokens = line.split("\\s+");
        Collections.addAll(usedVariables, tokens);
    }

    private boolean isDeadCode(String line, Set<String> usedVariables) {
        String[] parts = line.split("=");
        if (parts.length == 2) {
            String target = parts[0].trim();
            return !usedVariables.contains(target);
        }
        return false;
    }

    public static void main(String[] args) { // test with a simple code
        List<String> tacCode = Arrays.asList(
                "t1 = a + b",
                "t2 = t1 + c",
                "t3 = 5 + 3",
                "t4 = t3 * 2",
                "result = t4",
                "print result"
        );

        CodeOptimizer optimizer = new CodeOptimizer();
        List<String> optimizedCode = optimizer.optimize(tacCode);

        System.out.println("Original Code:");
        tacCode.forEach(System.out::println);

        System.out.println("\nOptimized Code:");
        optimizedCode.forEach(System.out::println);
    }
}
