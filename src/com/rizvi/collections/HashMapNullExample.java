package com.rizvi.collections;

import java.util.HashMap;
import java.util.TreeMap;

public class HashMapNullExample {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        // Adding a null key with a non-null value
        map.put(null, "Value for null key");

        // Adding a non-null key with a non-null value
        map.put("key1", null);

        // Adding a null key with a non-null value
        map.put(null, "Value for null2 key");

        // Adding an another null key with a non-null value
        map.put("key2", null);

        System.out.println(map);

        TreeMap<String, String> treeMap = new TreeMap<>();

        map.put(null, "Value for null key");
    }
}
