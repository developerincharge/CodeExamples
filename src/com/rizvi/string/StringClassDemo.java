package com.rizvi.string;

public class StringClassDemo {

    public static void main(String[] args) {

        String s1 = new String("JVM");
        String str = "Karachi";
        String s2 = "JVM";
        String s3 = "Karachi";
        String s4 = "JVM";

        System.out.println("s1 == s2 :- "+(s1==s2)); // false
        System.out.println("s2 == s4 :- "+(s2==s4)); // true
        System.out.println("str == s3 :- "+(str==s3)); // true

        String s5 = "Hello";
        String s6 = "Hello";
        String s7 = "hello";

        System.out.println("s5 == s6 :- "+(s5==s6)); // true
        System.out.println("s5 == s7 :- "+(s5==s7)); // false
        System.out.println("s6 == s7 :- "+(s6==s7)); // false


    }
}
