package controlstatements;

import java.util.Scanner;

public class ExitOnExit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a number (or type 'exit' to quit):");
            String userInput = input.next();
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program. Goodbye!");
                break; // Exit the loop and end the program
            }
            try {
                int number = Integer.parseInt(userInput);
                System.out.println("You entered: " + number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'exit' to quit.");
            }
        }
    }
}
