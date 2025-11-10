package singlereponsibility;

// Input Validator class - responsible for validation only
public class InputValidator {
    public static final int MIN_RANGE = 0;
    public static final int MAX_RANGE = 10;

    public static boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean isInValidRange(int number) {
        return number >= MIN_RANGE && number <= MAX_RANGE;
    }
}

