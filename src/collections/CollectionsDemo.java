package collections;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsDemo {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(50);
        numbers.add(10);
        numbers.add(30);
        numbers.add(80);
        numbers.add(20);
        numbers.add(40);
        numbers.add(50);

        System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println(numbers);
        Collections.reverse(numbers);
        System.out.println(numbers);
        Collections.shuffle(numbers);
        System.out.println(numbers);
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);
        System.out.println(min);
        System.out.println(max);

        numbers.stream().sorted().distinct().forEach(s ->{
            System.out.print(","+s);
        });

    }
}
