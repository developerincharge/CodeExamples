package stream;

import java.util.Arrays;
import java.util.List;

public class SumOfSquaresOfEvenNumbers {



    public static void main(String[] args) {
       // Examples of combining filter + map + reduce in a single stream pipeline
        System.out.println("Squares and sum of even numbers by combining filter + map + reduce in a single stream ");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter even numbers -> Map to squares -> Reduce by summing
        int result = numbers.stream()
                .filter(n -> n % 2 == 0)           // Keep only even numbers
                .map(n -> n * n)                   // Square each number
                .reduce(0, Integer::sum);          // Sum all squared values

        System.out.println("Sum of squares of even numbers: " + result); // 4+16+36+64+100=220
    }
}