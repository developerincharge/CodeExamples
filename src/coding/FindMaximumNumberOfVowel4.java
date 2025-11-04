package coding;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindMaximumNumberOfVowel4{

    public static void main(String[] args) {
        String str = "The quick brown fox jumps right over the little lazy dog.";
        String vowels = "AEIOUaeiou";

        // Create a map of words with their vowel counts
        List<String> words = Arrays.asList(str.split(" "));
        Map<String, Long> wordVowelCounts = words.stream()
                .collect(Collectors.toMap(
                        word -> word,
                        word -> word.chars()
                                .filter(ch -> vowels.indexOf(ch) >= 0)
                                .count()
                ));

        // Find the maximum vowel count
        long maxCount = wordVowelCounts.values().stream()
                .max(Long::compareTo)
                .orElse(0L);

        // Get all words with the maximum count
        String result = wordVowelCounts.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(","));

        System.out.println(result); // Output: over,little
    }
}
