package com.rizvi.streams;

import java.util.*;

class ArrayMapper {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 5};
        
        // Convert arr1 to a Set for O(1) lookup
        Set<Integer> keySet = new HashSet<>();
        for (int num : arr1) {
            keySet.add(num);
        }
        
        // Create Map with Integer key and List<Integer> value
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // Initialize map with keys from arr1
        for (int key : arr1) {
            map.put(key, new ArrayList<>());
        }
        
        // Iterate through arr2 and add values to corresponding keys
        for (int value : arr2) {
            if (keySet.contains(value)) {
                map.get(value).add(value);
            }
        }
        
        // Print the result
        System.out.println("Key -> Value mapping:");
        System.out.println("=========================");
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println("Key " + entry.getKey() + " -> " + entry.getValue());
        }
        
        // Also show which elements from arr2 were ignored
        System.out.println("\nElements from arr2 that don't have keys:");
        System.out.println("=========================");
        List<Integer> ignored = new ArrayList<>();
        for (int value : arr2) {
            if (!keySet.contains(value)) {
                ignored.add(value);
            }
        }
        if (!ignored.isEmpty()) {
            System.out.println(ignored);
        } else {
            System.out.println("None");
        }
    }
}