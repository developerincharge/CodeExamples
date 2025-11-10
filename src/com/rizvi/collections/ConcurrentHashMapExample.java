package com.rizvi.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    public static void main(String[] args) {

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
         map.put("A", 1);
         map.put("B", 2);
         map.put("C", 3);
        Set<Map .Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entry = entrySet.iterator();

        while(entry.hasNext()){
            map.putIfAbsent("D", 4);
            System.out.println("Concurrent  : "+entry.next());
        }

        HashMap<String , Integer> hashMap = new HashMap<>();
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);
        Set<Map.Entry <String, Integer>> hashMapSet = hashMap.entrySet();
        Iterator<Map.Entry <String, Integer>> entry1 = hashMapSet.iterator();

        while(entry1.hasNext()){
            hashMap.putIfAbsent("D", 4);
            System.out.println("HashMap  : "+entry1.next());
        }
    }
}
