package collections;

import java.util.HashSet;
import java.util.Iterator;

public class IteratorDemo {

    public static void main(String[] args) {

        HashSet<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Pineapple");
        fruits.add("Strawberry");
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        Iterator<String> iterator = fruits.iterator();
        System.out.println(fruits);

        System.out.println("Removing 'Banana' while iterating");

        while(iterator.hasNext()){
            String fruit = iterator.next();

            if(fruit.equals("Banana")){
                iterator.remove();
            }
        }

        System.out.println("Updated list  "+fruits);

    }
}
