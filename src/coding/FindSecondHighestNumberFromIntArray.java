package coding;

import java.util.Arrays;
import java.util.Comparator;

public class FindSecondHighestNumberFromIntArray {

    public static void main(String[] args) {
        int[] numbers = {5, 13, 41, 88, 99, 77};

        // find the second-highest number

        // using enhanced for loop
        int secondHighest = -1;
        int highest = -1;

        for (int number : numbers) {
            if (number > highest) {
                secondHighest = highest;
                highest = number;
            } else if (number > secondHighest && number != highest) {
                secondHighest = number;
            }
        }

        System.out.println("Second highest number is: " + secondHighest);

       // using traditional for loop

//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i] > highest) {
//                secondHighest = highest;
//                highest = numbers[i];
//            } else if (numbers[i] > secondHighest && numbers[i] != highest) {
//                secondHighest = numbers[i];
//            }
//        }

       // using Stream Api
    Integer secondHighest1 = Arrays.stream(numbers)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .distinct()
            .skip(1)
            .findFirst()
            .orElse(-1);

    System.out.println("Second highest number by Stream Api is: " + secondHighest1);

         // finding second-lowest number in Int Array

        Integer secondLowest = Arrays.stream(numbers)
                .boxed()
                .sorted()
                .distinct()
                .skip(1)
                .findFirst()
                .orElse(-1);

        System.out.println("Second lowest number by Stream Api is: " + secondLowest);

     }
}
