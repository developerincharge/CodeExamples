package array;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {

        Set<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(25);
        numbers.add(30);
        numbers.add(35);
        numbers.add(30);

        System.out.println("Hashset contents "+numbers);

        boolean hasTen = numbers.contains(10);
        System.out.println("Does the list contains Ten ? : "+hasTen);

        numbers.remove(35);
        System.out.println("Hash set after removing digit 35 : "+numbers);

    }
}
