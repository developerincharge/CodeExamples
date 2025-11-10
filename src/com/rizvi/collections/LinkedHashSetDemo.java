package com.rizvi.collections;

import java.util.ArrayList;
import java.util.LinkedHashSet;
public class LinkedHashSetDemo {
   public static void main(String[] args) {
      // Creating Empty LinkedHashSet using default constructor..
      LinkedHashSet hashSet1 = new LinkedHashSet();
      System.out.println("hasSet1 :- " + hashSet1);
      System.out.println("hashSet1 size :- " + hashSet1.size());
      System.out.println("hashSet1 is empty :- " + hashSet1.isEmpty());
      ArrayList a1 = new ArrayList();
      a1.add("Hello");
      a1.add(101);
      a1.add(true);
      a1.add(101);
      a1.add(new LinkedHashSetDemo());
      a1.add('A');
      System.out.println("\nArray List :- " + a1);
      // Creating LinkedHashSet using java.util.LikedHashSet(Collection) constructor..
      LinkedHashSet hashSet2 = new LinkedHashSet(a1);
      System.out.println("hashSet2 :- " + hashSet2);
      System.out.println("hashSet2 size :- " + hashSet2.size());
      System.out.println("hashSet2 is empty :- " + hashSet2.isEmpty());
   }
}