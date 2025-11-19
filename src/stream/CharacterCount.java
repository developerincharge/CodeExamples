package stream;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterCount {

    public static void main(String[] args) {

        String names = "Syed, Imtiaz, Hassan, Rizvi";
        Map<String, Long> charToCounts = Arrays.stream(names.split(""))

                .filter(s -> !s.isBlank())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        charToCounts.forEach((character, count) -> System.out.println("character: "+ character + " ->  count :"  + count));
    }
}
