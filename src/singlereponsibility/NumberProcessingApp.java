package singlereponsibility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberProcessingApp {
    public static final int THRESHOLD = 5;

    public static void main(String[] args) {
        DisplayHandler.showWelcomeMessage();

        List<Integer> numbers = collectValidNumbers();
        NumberSorter.sortNumbers(numbers);
        DisplayHandler.showResults(numbers);
    }

    public static List<Integer> collectValidNumbers() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        DisplayHandler.showInputPrompt(THRESHOLD);

        while (numbers.size() < THRESHOLD) {
            String input = scanner.nextLine().trim();

            if (!InputValidator.isValidInteger(input)) {
                DisplayHandler.showInvalidInputMessage();
                continue;
            }

            int number = NumberConverter.convertToInteger(input);

            if (!InputValidator.isInValidRange(number)) {
                DisplayHandler.showInvalidRangeMessage();
                continue;
            }

            numbers.add(number);
        }

        scanner.close();
        return numbers;
    }
}