import java.util.Scanner;

public class MathCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Format: (number) space (operator) space (number)");

        while (true) {
            System.out.print("Type in the equation you need help with(Type 'exit' to quit): ");
            String question = scanner.nextLine().toLowerCase();

            if (question.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            String answer = answerQuestion(question);
            System.out.println("Answer: " + answer);
        }
    }

    public static String answerQuestion(String question) {
        String[] tokens = question.split("\\s+");

        if (tokens.length != 3) {
            return "Invalid question format. Please provide a question in the format: (number) space (operator) space (number)";
        }

        try {
            double num1 = Double.parseDouble(tokens[0]);
            String operator = tokens[1];
            double num2 = Double.parseDouble(tokens[2]);

            double result;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                default:
                    return "Unsupported operator. Please use one of: +, -, *, /";
            }

            return Double.toString(result);
        } catch (NumberFormatException e) {
            return "Invalid numbers. Please provide valid numerical values.";
        } catch (ArithmeticException e) {
            return "Arithmetic error: " + e.getMessage();
        }
    }
}
