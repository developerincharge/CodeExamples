package stream;

import java.util.Arrays;
import java.util.List;


public class ConcatenateCapitalizeWordsGreaterThan3 {


    public static void main(String[] args) {

        // Examples of combining filter + map + reduce in a single stream pipeline
        System.out.println("###  Concatenate capitalized words with length > 3  #####");

        List<String> words = Arrays.asList("java", "stream", "api", "with", "lambda", "of", "code", "method");

        // Filter long words -> Map to uppercase -> Reduce by concatenating
        String result = words.stream()
                .filter(word -> word.length() > 3)  // Words longer than 3 chars
                .map(String::toUpperCase)     // Convert to uppercase
                .reduce("", (acc, word) -> acc + " " + word) // Concatenate with spaces
                .trim();   // Remove leading space

        System.out.println("Concatenated long words: " + result); // JAVA STREAM LAMBDA METHOD CODE
    }
}