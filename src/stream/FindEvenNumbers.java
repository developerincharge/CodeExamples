package stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindEvenNumbers {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
        list.stream().filter((x)->x%2==0).forEach(System.out::println);

        System.out.println("############################");

       List<String> listWith1 =  list.stream().map(n -> n +" ")
               .filter(num -> num.startsWith("1"))
                .toList();
        System.out.println(listWith1);

        System.out.println("############################");

        Set<Integer> set = new HashSet<>();
        list.stream().filter(n -> !set.add(n))

                .forEach(System.out::println);



    }
}
