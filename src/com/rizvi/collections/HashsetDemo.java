package com.rizvi.collections;



import java.util.HashSet;
public class HashsetDemo {
   public static void main(String[] args) {
      HashSet set = new HashSet();
      System.out.println("Added :- " + set.add(101));
      System.out.println("Added :- " + set.add("Hello"));
      System.out.println("Added :- " + set.add('A'));
      System.out.println("Added :- " + set.add(true));
      System.out.println("Added :- " + set.add(101));
      System.out.println("Added :- " + set.add(new HashsetDemo()));
      System.out.println("Added :- " + set.add(null));
      System.out.println("Added :- " + set.add(12.34));
      System.out.println("Number of elements :- " + set.size());
      System.out.println("Empty Status :- " + set.isEmpty());
      System.out.println("Elements availability :- " + set.contains("Hello"));
      System.out.println("Elements availability :- " + set.contains("HashsetDemo"));
      System.out.println("set :- " + set);
      System.out.println("Removing Element :- " + set.remove(101));
      System.out.println("set :- " + set);
      System.out.println("Removing Element :- " + set.remove("HashsetDemo"));
   }
}