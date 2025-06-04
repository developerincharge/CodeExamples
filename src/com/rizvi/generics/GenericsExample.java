package com.rizvi.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {

    public static void main(String[] args) {


        List<String> intList = new ArrayList<>();
        intList.add("Jim");
        intList.add("Jane");
        intList.add("Joe");
        intList.add("Carl");
        printList(intList);

    }
    private static void printList(List<?> myList){
        System.out.println(myList);
    }
}
