import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.script.ScriptException;

public class ExpressionEvaluator {
    public static void main(String[] args) throws ScriptException {
        // Create a Map to store variables and their values
        Map<String, Double> variables = new HashMap<>();

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Read and evaluate expressions until the user enters "0"
        while (true) {
            System.out.print("Enter an expression (or '0' to exit): ");
            String expression = scanner.nextLine();

            if (expression.equals("0")) {
                break; // Exit the loop if the user enters "0"
            }

            double result = evaluateExpression(variables, expression);
            System.out.println("Result: " + result);
        }

        // Close the Scanner to prevent resource leaks
        scanner.close();
    }

    // Evaluate an expression based on the stored variables
    private static double evaluateExpression(Map<String, Double> variables, String expression) throws ScriptException {
        // Replace variable names with their values in the expression
        for (Map.Entry<String, Double> entry : variables.entrySet()) {
            expression = expression.replace(entry.getKey(), entry.getValue().toString());
        }

        // Use the JavaScript engine for simple expression evaluation
        // Note: This requires Java 8 or later
        return (double) new javax.script.ScriptEngineManager()
                .getEngineByName("js")
                .eval(expression);
    }
}

