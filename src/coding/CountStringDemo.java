package coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountStringDemo {


    public static void main(String[] args) {

        List<String> names = Arrays.asList("Hello", "Worlds");

        for (var name : names) System.out.println(name + " -> " + name.length());

        System.out.println("#########################");

        ArrayList<String> resultList = new ArrayList<>();

        names.forEach((name)->{
            String newValue = countLength(name);
            resultList.add(newValue);
            System.out.println(newValue + " -> " + name.length());
        });
    }

    public static String countLength(String name) {
        return name;
    }

}
