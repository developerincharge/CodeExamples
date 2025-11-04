package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FirstLongestWordStartsWithSpecificLetter {
    public static void main(String[] args) {
        // Examples of combining filter + map + reduce in a single stream pipeline

        List<String> words = Arrays.asList("apple", "banana", "apricot", "avocado", "berry", "cherry");
        // Filter words starting with 'a' -> Map to length -> Reduce to find max length
        Optional<Integer> maxLength = words.stream()
                .filter(word -> word.startsWith("a"))  // Words starting with 'a'
                .map(String::length)      // Convert to length
                .reduce(Integer::max);    // Find maximum length

        System.out.println("Longest word starting with 'a' has length: " +
                maxLength.orElse(0)); // 7 (apricot)
    }
}