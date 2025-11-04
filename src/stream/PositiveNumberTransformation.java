package stream;

import java.util.Arrays;
import java.util.List;

public class PositiveNumberTransformation {
    public static void main(String[] args) {

        // Examples of combining filter + map + reduce in a single stream pipeline
        System.out.println("## Product of positive numbers after transformation ##");
        List<Double> numbers = Arrays.asList(2.0, -1.0, 3.5, -4.0, 1.5, 2.5);

        // Filter positive numbers -> Map (x * 2 + 1) -> Reduce by multiplying
        double result = numbers.stream()
                .filter(n -> n > 0)  // Only positive numbers
                .map(n -> n * 2 + 1) // Transform: 2x + 1
                .reduce(1.0, (acc, n) -> acc * n); // Multiply all values

        System.out.println("Product of transformed positive numbers: " + result);
        // Calculation: (2*2+1)=5 * (3.5*2+1)=8 * (1.5*2+1)=4 * (2.5*2+1)=6 = 5*8*4*6=960
    }
}
