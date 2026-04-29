package controlstatements;

import java.util.Scanner;

public class CalculatorSwitch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number:");
        double num1 = input.nextDouble();
        System.out.print("Enter second number:");
        double num2 = input.nextDouble();
        System.out.print("Enter an operator (+, -, *, /):");
        char operator = input.next().charAt(0);
        System.out.println("Result: " + calculate(num1, num2, operator));
        input.close();
    }

    public static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    return Double.NaN; // Not a Number
                }
            default:
                System.out.println("Error: Invalid operator.");
                return Double.NaN; // Not a Number

          }

       }

  }