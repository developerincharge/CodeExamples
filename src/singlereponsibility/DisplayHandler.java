package singlereponsibility;

import java.util.List;

public class DisplayHandler {
    public static void showWelcomeMessage() {
        System.out.println("Welcome to the Application!");
    }

    public static void showInputPrompt(int threshold) {
        System.out.println("Enter " + threshold + " valid integers in the range [0, 10]");
    }

    public static void showInvalidInputMessage() {
        System.out.println("Invalid! Try again!");
    }

    public static void showInvalidRangeMessage() {
        System.out.println("Invalid range! Try again!");
    }

    public static void showResults(List<Integer> numbers) {
        System.out.print("Sorted numbers: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        System.out.println();

    }
}