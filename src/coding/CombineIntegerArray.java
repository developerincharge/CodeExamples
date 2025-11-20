package coding;

import java.util.*;
import java.util.stream.*;

public class CombineIntegerArray {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8, 9, 10);
        
        // Test different approaches
        System.out.println("Combined: " + Arrays.toString(combineLists(list1, list2)));
        System.out.println("Unique: " + Arrays.toString(combineListsUnique(list1, list2)));
        System.out.println("Sorted Unique: " + Arrays.toString(combineSortedUnique(list1, list2)));
    }
    
    private static int[] combineLists(List<Integer> list1, List<Integer> list2) {
        return Stream.concat(list1.stream(), list2.stream())
                .mapToInt(Integer::intValue)
                .toArray();
    }
    
    private static int[] combineListsUnique(List<Integer> list1, List<Integer> list2) {
        return Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    
    private static int[] combineSortedUnique(List<Integer> list1, List<Integer> list2) {
        return Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}