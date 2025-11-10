package com.rizvi.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class HashSetDemo1 {

    public static void main(String[] args) {

        HashSet hs = new HashSet();
        hs.add(123);
        hs.add("abc");
        hs.add(123);
        System.out.println(hs);

        TreeSet ts = new TreeSet();
        ts.add("dd");
        ts.add("aa");
        //ts.add(1234);
        ts.add("ee");
        ts.add("cc");
        ts.add("ff");
        System.out.println(ts);


        HashMap hm = new HashMap();
        hm.put("sid", 1233);
        hm.put("Name", "Syed");
        System.out.println(hm);


    }
}
