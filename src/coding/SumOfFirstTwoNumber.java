package coding;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SumOfFirstTwoNumber {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

        Optional<Integer> sumOfFirstTwo = numbers.stream()
                .limit(2)
                .reduce((x, y) -> x + y);
        sumOfFirstTwo.ifPresent(System.out::println);

    }
}
