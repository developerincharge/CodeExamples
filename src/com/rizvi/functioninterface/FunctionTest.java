package com.rizvi.functioninterface;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
       Function<Integer, String> function = (t)-> "output : "+t;
        System.out.println(function.apply(88));

    }
}
