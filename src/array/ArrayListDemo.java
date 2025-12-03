package array;

import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        System.out.println(numbers+"\n");


        ArrayList<String> colors = new ArrayList<>();

        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        System.out.println(colors);
        System.out.println(colors.get(0));
        colors.set(2, "Yellow");

        System.out.println(colors);

        colors.remove(0);
        System.out.println(colors);

        colors.set(0, "Violet");
        System.out.println(colors);
    }


}
