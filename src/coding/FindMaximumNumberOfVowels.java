package coding;

import java.util.*;
import java.util.stream.Collectors;

public class FindMaximumNumberOfVowels {

    public static void main(String[] args) {
        String str = "The quick brown fox jumps right over the little lazy dog.";
        String vowels = "AEIOUaeiou";
        
        String result = Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(
                    word -> countVowels(word, vowels),
                    TreeMap::new,
                    Collectors.toList()
                ))
                .lastEntry()
                .getValue()
                .stream()
                .collect(Collectors.joining(","));
        
        System.out.println(result);
    }
    
    private static long countVowels(String word, String vowels) {
        return word.chars()
                   .filter(ch -> vowels.indexOf(ch) >= 0)
                   .count();
    }
}