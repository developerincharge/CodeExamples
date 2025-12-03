package array;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {

        LinkedList<String> names = new LinkedList<>();
        names.add("John");
        names.add("Bob");
        names.add("Ane");
        names.add("Zain");

        System.out.println("Names: "+names);

        System.out.println("First Person Name : "+ names.getFirst());
        System.out.println("Last Person Name : "+ names.getLast());
        System.out.println("Skip First Person: "+ Arrays.toString(names.stream().skip(1).toArray()));
        System.out.println("Skip Last Person: "+ Arrays.toString(names.stream().limit(2).toArray()));

    }
}
