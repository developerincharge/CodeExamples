package generics;


import java.util.ArrayList;
import java.util.List;

public class TypeLowerBoundAndWildCard {

    public static void addNumbers(List<? super Integer> list){

        for(int i = 1; i <= 5; i++){
          list.add(i);
        }

    }

    public static void main(String[] args) {

        List<Number> numberList = new ArrayList<>();
        addNumbers(numberList);

        System.out.println(numberList);

    }
}
