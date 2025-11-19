package stream;

import java.util.Arrays;
import java.util.List;

public class MapFlatMapExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "stream", "api");
        List<Integer> wordsLength = words.stream()
                .map(String::length)
                .toList();

        System.out.println("######################");

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> flattendList = listOfLists.stream()
                        .flatMap(List::stream)
                                .toList();

        System.out.println("Words Length  :  "+wordsLength);
        System.out.println("FlattendList  :  "+flattendList);

        System.out.println("##########################");

        List<String> sentences = Arrays.asList("java stream", "hello world");
        sentences.stream()
                .map(sentence -> sentence.split(" "))
                .forEach(str -> System.out.println(Arrays.toString(str)));

        List<String> flatMapped = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .toList();
        System.out.println("Flat map result :  "+flatMapped);
    }
}
