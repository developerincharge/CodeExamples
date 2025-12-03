package collections;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorDemo {

    public static void main(String[] args) {
         ArrayList<String> animals = new ArrayList<>();
         animals.add("cat");
         animals.add("dog");
         animals.add("horse");
         animals.add("cow");
         animals.add("rabbit");

         ListIterator<String> iterator = animals.listIterator();

        System.out.println("Iterating forward in the list: ");
        while(iterator.hasNext()){
            System.out.println(iterator.next());

        }

        System.out.println("\nIterating backward in the list: ");
        while(iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }



    }
}
