package Task1;

import java.util.Stack;

public class RPNCalculator {
    public static void main(String[] args) {
        String expression = "3 4 + 2 *"; // пример выражения в обратной польской нотации
        double result = evaluateRPN(expression);
        System.out.println("Результат: " + result);
    }

    public static double evaluateRPN(String expression) {
        Stack<Double> stack = new Stack<>();

        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();

                double result;
                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Неверный оператор: " + token);
                }

                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
