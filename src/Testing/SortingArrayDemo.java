package Testing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortingArrayDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        System.out.println(names);
        List<Integer> lengthOfWord = names.stream().sorted().distinct().map(String::length).collect(Collectors.toList());
        System.out.println(lengthOfWord);

    }
}
