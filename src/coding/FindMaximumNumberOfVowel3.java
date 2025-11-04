package coding;

import java.util.*;
import java.util.stream.Collectors;

public class FindMaximumNumberOfVowel3 {

    public static void main(String[] args) {
        String str = "The quick brown fox jumps right over the little lazy dog.";
        String vowels = "AEIOUaeiou";

        String result = Arrays.stream(str.split(" "))
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(
                                word -> word.chars()
                                        .filter(ch -> vowels.indexOf(ch) >= 0)
                                        .count(),
                                TreeMap::new,
                                Collectors.toList()
                        ),
                        map -> map.isEmpty() ? "" :
                                map.lastEntry().getValue().stream()
                                        .collect(Collectors.joining(","))
                ));

        System.out.println(result);
    }
}