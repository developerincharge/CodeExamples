package coding;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindMaximumNumberOfVowel1 {

    public static void main(String[] args) {

        String str = "The quick brown fox jumps right over the little lazy dog.";
        String vowels = "AEIOUaeiou";

        // Group words by their vowel count
        Map<Long, List<String>> wordsByVowelCount = Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(
                        word -> word.chars()
                                .filter(ch -> vowels.indexOf(ch) >= 0)
                                .count()
                ));

        // Find the maximum vowel count
        Optional<Long> maxVowelCount = wordsByVowelCount.keySet()
                .stream()
                .max(Long::compareTo);

        // Get all words with the maximum vowel count and join them with commas
        String result = maxVowelCount
                .map(count -> wordsByVowelCount.get(count).stream()
                        .collect(Collectors.joining(",")))
                .orElse("");

        System.out.println(result);
    }
}

