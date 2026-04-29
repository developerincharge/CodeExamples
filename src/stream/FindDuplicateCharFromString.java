package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateCharFromString {

    String str = "gainingprogrammingknwoledge";

        public void findDuplicateChar() {

            str.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter(e -> e.getValue() > 1)
                    .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
        }

    public static void main(String[] args) {
        FindDuplicateCharFromString obj = new FindDuplicateCharFromString();
        obj.findDuplicateChar();

        String str = "gainingprogrammingknwoledge";
        List<String> duplicateElements = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(ele -> ele.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(duplicateElements);
    }

}
