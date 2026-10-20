import java.util.Scanner;

class CalculatorOperations {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException(
                "Cannot divide by zero."
            );
        }
        return a / b;
    }

    public double getSquareRoot(double number) {
        if (number < 0) {
            throw new ArithmeticException(
                "Cannot calculate the square root of a negative number."
            );
        }
        return Math.sqrt(number);
    }

    public double getPower(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}

class Calculator {

    private Scanner input;
    private CalculatorOperations operations;

    public Calculator() {
        input = new Scanner(System.in);
        operations = new CalculatorOperations();
    }

    public void displayMenu() {
        System.out.println("\n================================");
        System.out.println("       OOP JAVA CALCULATOR");
        System.out.println("================================");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Square Root");
        System.out.println("6. Exponentiation (Power)");
        System.out.println("7. Exit");
        System.out.println("================================");
        System.out.print("Choose an operation: ");
    }

    private double readNumber(String message) {
        while (true) {
            System.out.print(message);

            if (input.hasNextDouble()) {
                return input.nextDouble();
            }

            System.out.println(
                "Invalid input. Please enter a valid number."
            );
            input.next();
        }
    }

    public void run() {
        int choice = 0;

        System.out.println("Welcome to the OOP Java Calculator!");

        while (choice != 7) {
            displayMenu();

            if (!input.hasNextInt()) {
                System.out.println(
                    "Invalid choice. Enter a number from 1 to 7."
                );
                input.next();
                continue;
            }

            choice = input.nextInt();

            if (choice == 7) {
                System.out.println(
                    "Thank you for using the calculator!"
                );
                break;
            }

            if (choice < 1 || choice > 7) {
                System.out.println(
                    "Invalid choice. Please try again."
                );
                continue;
            }

            try {
                double firstNumber;
                double secondNumber;
                double result;

                switch (choice) {
                    case 1:
                        firstNumber = readNumber("First number: ");
                        secondNumber = readNumber("Second number: ");
                        result = operations.add(
                            firstNumber, secondNumber
                        );
                        showResult(
                            firstNumber + " + " + secondNumber,
                            result
                        );
                        break;

                    case 2:
                        firstNumber = readNumber("First number: ");
                        secondNumber = readNumber("Second number: ");
                        result = operations.subtract(
                            firstNumber, secondNumber
                        );
                        showResult(
                            firstNumber + " - " + secondNumber,
                            result
                        );
                        break;

                    case 3:
                        firstNumber = readNumber("First number: ");
                        secondNumber = readNumber("Second number: ");
                        result = operations.multiply(
                            firstNumber, secondNumber
                        );
                        showResult(
                            firstNumber + " * " + secondNumber,
                            result
                        );
                        break;

                    case 4:
                        firstNumber = readNumber("First number: ");
                        secondNumber = readNumber("Second number: ");
                        result = operations.divide(
                            firstNumber, secondNumber
                        );
                        showResult(
                            firstNumber + " / " + secondNumber,
                            result
                        );
                        break;

                    case 5:
                        firstNumber = readNumber("Enter a number: ");
                        result = operations.getSquareRoot(firstNumber);
                        showResult(
                            "Square root of " + firstNumber,
                            result
                        );
                        break;

                    case 6:
                        firstNumber = readNumber("Enter the base: ");
                        secondNumber = readNumber("Enter the exponent: ");
                        result = operations.getPower(
                            firstNumber, secondNumber
                        );
                        showResult(
                            firstNumber + " ^ " + secondNumber,
                            result
                        );
                        break;
                }

            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void showResult(String expression, double result) {
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            System.out.println("Error: Result is undefined or too large.");
        } else {
            System.out.println("Result: " + expression + " = " + result);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run();
    }
}
