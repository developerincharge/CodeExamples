package coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountStringDemo {

    public static String countLength(String name) {
        return name;
    }

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Hello", "World");

        ArrayList<String> resultList = new ArrayList<>();

        names.forEach((name)->{
            String newValue = countLength(name);
            resultList.add(newValue);
            System.out.println(name.length()+" -> "+name);
        });

        System.out.println("#########################");

        for (String name : names) {
            System.out.println(name + " -> " + name.length());
        }

    }



}
