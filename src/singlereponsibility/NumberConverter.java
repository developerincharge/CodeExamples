package singlereponsibility;

import java.util.Collections;
import java.util.List;

public class NumberConverter {
    public static int convertToInteger(String input) {
        return Integer.parseInt(input);
    }
}

// Number Sorter class - responsible for sorting only
class NumberSorter {
    public static void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);

    }
}
