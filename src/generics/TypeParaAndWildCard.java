package generics;


import java.util.Arrays;
import java.util.List;

public class TypeParaAndWildCard {

    public static double sumOfNumbers(List<? extends Number> list){
        double sum = 0.0;
        for(Number number : list){
            sum += number.doubleValue();
        }
        return sum;
    }


    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubleList = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);

        System.out.println(sumOfNumbers(intList));
        System.out.println(sumOfNumbers(doubleList));
    }
}
