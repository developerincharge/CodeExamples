package com.rizvi.collections;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparatorDemo {
   public static void main(String[] args) {
      ArrayList < Student > s1 = new ArrayList < Student > ();
      s1.add(new Student(101, "Vivek", "Noida", 89));
      s1.add(new Student(102, "Amit", "Delhi", 89));
      s1.add(new Student(101, "Vivek", "Noida", 89));
      s1.add(new Student(100, "Neha", "Patna", 89));
      System.out.println("s1 :- " + s1);
      s1.sort(new MyCompare());
      System.out.println("s1 :- " + s1);
   }
}
class MyCompare implements Comparator < Student > {
   @Override
   public int compare(Student s1, Student s2) {
      if (s1.sid > s2.sid) {
         return 1;
      }
      else if(s1.sid == s2.sid) {
         return 0;
      } else {
         return -1;
      }
   }
}
class Student {
   int sid;
   String sname;
   String scity;
   public Student(int sid, String sname, String scity, int i) {
      this.sid = sid;
      this.sname = sname;
      this.scity = scity;
   }
   @Override
   public String toString() {
      return "Student [sid=" + sid + ", sname=" + sname + ", scity=" + scity + "]";
   }
}