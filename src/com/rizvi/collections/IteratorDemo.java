package com.rizvi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {
   public static void main(String[] args) {
      // ArrayList is storing the elements in added order.
      ArrayList al1 = new ArrayList();
      al1.add(101);
      al1.add(102);
      al1.add(103);
      al1.add(104);
      al1.add(105);
      al1.add(101);
      System.out.println("al1 :- " + al1);
      // We are accessing the element of an ArrayList using their Index.
      System.out.println("---------------------------------");
      for (int i = 0; i <= al1.size() - 1; i++) {
         System.out.println("Index :- " + i + " | Value :- " + al1.get(i));
      }
      // Traversing ArrayList using Iterator :
      System.out.println("---------------------------------");
      Iterator iterator = al1.iterator();
      while (iterator.hasNext()) {
         System.out.print(iterator.next() + " ");
      }
      System.out.println("\n---------------------------------");
      // Traversing ArrayList using List-Iterator :
      ListIterator listIterator = al1.listIterator();
      System.out.print("In Forward Order :- ");
      while (listIterator.hasNext()) {
         System.out.print(listIterator.next() + " ");
      }
      System.out.print("\nIn Reverse Order :- ");
      while (listIterator.hasPrevious()) {
         System.out.print(listIterator.previous() + " ");
      }
      System.out.println();
      // Creating Clone of ArrayList :
      ArrayList clone = (ArrayList) al1.clone();
      System.out.println("Original ArrayList :- " + al1);
      System.out.println("Clone ArrayList :- " + clone);
   }
}