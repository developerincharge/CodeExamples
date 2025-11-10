package coding;

import java.util.*;
import java.util.stream.Collectors;

public class FindMaximumNumberOfVowel2 {

    public static void main(String[] args) {
        String str = "The quick brown fox jumps right over the little lazy dog.";
        String vowels = "AEIOUaeiou";

        Map<Long, List<String>> vowelCountMap = Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(
                        word -> word.chars()
                                .filter(ch -> vowels.indexOf(ch) >= 0)
                                .count()));

        long maxVowels = vowelCountMap.keySet().stream()
                .max(Long::compareTo)
                .orElse(0L);

        String result = vowelCountMap.get(maxVowels).stream()
                .collect(Collectors.joining(","));

        System.out.println(result);
    }
}
