package singlereponsibility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumberSorterApp {
    public static final int THRESHOLD = 5;
    public static final int MIN_RANGE = 0;
    public static final int MAX_RANGE = 10;

    public static void main(String[] args) {
        System.out.println("Welcome to the Application!");
        
        List<Integer> numbers = collectValidNumbers();
        sortNumbers(numbers);
        displayResults(numbers);
    }

    /**
     * Collects valid integers from user input
     * @return List of valid integers
     */
    public static List<Integer> collectValidNumbers() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        
        System.out.println("Enter " + THRESHOLD + " valid integers in the range [" + MIN_RANGE + ", " + MAX_RANGE + "]");
        
        while (numbers.size() < THRESHOLD) {
            String input = getInput(scanner);
            
            if (!isValidInteger(input)) {
                System.out.println("Invalid! Try again!");
                continue;
            }
            
            int number = convertToInteger(input);
            
            if (!isInValidRange(number)) {
                System.out.println("Invalid range! Try again!");
                continue;
            }
            numbers.add(number);
        }
        
        scanner.close();
        return numbers;
    }

    /**
     * Reads input from the scanner
     * @param scanner Scanner object for input
     * @return User input as string
     */
    public static String getInput(Scanner scanner) {
        return scanner.nextLine().trim();
    }

    /**
     * Validates if the input is a valid integer
     * @param input User input string
     * @return true if valid integer, false otherwise
     */
    public static boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * Converts string to integer
     * @param input Valid integer string
     * @return Integer value
     */
    public static int convertToInteger(String input) {
        return Integer.parseInt(input);
    }

    /**
     * Checks if number is within valid range
     * @param number Number to validate
     * @return true if within range, false otherwise
     */
    public static boolean isInValidRange(int number) {
        return number >= MIN_RANGE && number <= MAX_RANGE;
    }

    /**
     * Sorts the list of numbers in ascending order
     * @param numbers List of numbers to sort
     */
    public static void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    /**
     * Displays the sorted results
     * @param numbers List of numbers to display
     */
    public static void displayResults(List<Integer> numbers) {
        System.out.print("Sorted numbers: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}