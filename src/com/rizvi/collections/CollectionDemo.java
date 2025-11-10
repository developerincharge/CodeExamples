package com.rizvi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

class Hello {
    @Override
    public String toString() {
        return "Hello Object";
    }
}

public class CollectionDemo {
    public static void main(String[] args) {
        ArrayList<Object> al = new ArrayList<>();
        System.out.println(al);
        al.add(1234);
        al.add("Hello");
        System.out.println(al);
        al.add("World");
        al.add(new Hello());
        al.add(1234);
        System.out.println(al);

        System.out.println("############# Iterator ###############\n");
        Iterator<Object> itr = al.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("######### ListIterator ############\n");
        ListIterator<Object> listItr = al.listIterator();

        while(listItr.hasNext()) {
            System.out.println(listItr.next());
        }
        
        System.out.println("########## Previous ##########\n");
        while(listItr.hasPrevious()) {
            System.out.println(listItr.previous());
        }
    }
}