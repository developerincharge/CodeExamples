package string_coding;

import java.util.Arrays;
import java.util.stream.Stream;

public class CombineTwoStringArray {

    public static void main(String[] args) {

        String[] list1 = {"Doc", "Spy", "Doc", "sub", "Cart", "Spy", "Doc"};
        String[] list2 = {"Cart1", "Doc1", "Doc2", "Spy1", "Spy2"};

        String[] combined = combineLists(list1, list2);
        System.out.println("Combined: " + Arrays.toString(combined));
    }

    private static String[] combineLists(String[] list1, String[] list2) {

        return Stream.concat(Arrays.stream(list1),  Arrays.stream(list2))
                .toArray(String[]::new);
    }


}
