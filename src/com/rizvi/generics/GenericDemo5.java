package com.rizvi.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo5 {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        List list = new ArrayList();
        list = integers;
        list.add("some String");

        Integer integer = integers.get(0);
        System.out.println(integer);

    }
}
