package com.rizvi.string;

public class HashCodeEqualsDemo {

    public static void main(String[] args) {

        String s1 = new String("abc");
        String s2 = new String("abc");

        System.out.println("s1 == s2 :- "+(s1 == s2));
             // HashCode
        System.out.println("s1.hashCode :- "+s1.hashCode()); // 96354
        System.out.println("s2.hashCode :- "+s2.hashCode()); // 96354

           // Equals Method  checks and compare the content only not the location
           // with the new keyword its created in String poll at two locations
        System.out.println("s1 == s2 :- "+(s1 == s2)); // false
        System.out.println("s1.equals(s2) :- "+(s1.equals(s2))); // true


    }
}
