package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOperation {

// Examples of combining filter + map + reduce in a single stream pipeline

    public static void main(String[] args) {

        System.out.println("## filter + map + reduce operation - filter - intermediate and terminal for this complex reductions to sum ##");
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 6, 7, 8);
        System.out.println(list.stream()
                .filter(i->i%2==0)
                .map(i->i*i)
                .reduce(0, Integer::sum));

//        result = stream
//                .filter(predicate)    // What to keep
//                .map(transformer)     // How to transform
//                .reduce(identity, accumulator) // How to combine



        List<String> sentences = Arrays.asList(
                "Hello World",
                "Java Stream API",
                "Functional Programming",
                "Modern Java Features"
        );
        System.out.println("###### Using Collectors for more complex reductions #######");
        // Filter long sentences -> Map to word count -> Reduce to statistics
        String stats = sentences.stream()
                .filter(s -> s.length() > 10)                      // Long sentences
                .map(s -> s.split(" ").length)                     // Count words
                .collect(Collectors.teeing(
                        Collectors.averagingDouble(n -> n),           // Average word count
                        Collectors.summingInt(n -> n),                // Total words
                        (avg, total) -> String.format("Average: %.2f, Total: %d", avg, total)
                ));

        System.out.println("Word statistics: " + stats);
    }
}
