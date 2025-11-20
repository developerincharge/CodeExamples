package coding;

import java.util.*;
import java.util.stream.*;

public class ComprehensiveArrayOperations {
    public static void main(String[] args) {
        System.out.println("========== COMPREHENSIVE ARRAY OPERATIONS ==========\n");
        
        // Initialize sample data
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int[] array2 = {4, 5, 6, 7, 8, 9, 10};
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "strawberry", "pineapple");
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(1, 2, 5, 6);
        
        // Execute all operations
        demonstrateReverseString();
        demonstrateLongestString(fruits);
        demonstrateCombineLists(list1, list2);
        demonstrateMergeAndSortArrays(array1, array2);
    }
    
    // ==================== 1. REVERSE STRING OPERATION ====================
    private static void demonstrateReverseString() {
        System.out.println("1. REVERSE STRING OPERATION");
        System.out.println("=".repeat(50));
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to reverse: ");
        String str = scanner.nextLine();
        
        // Step-by-step explanation for reverse string
        System.out.println("\nStep-by-step string reversal:");
        System.out.println("Step 1: Convert string to character array");
        char[] charArray = str.toCharArray();
        System.out.println("   Character array: " + Arrays.toString(charArray));
        
        System.out.println("Step 2: Initialize swapping algorithm");
        int length = charArray.length;
        System.out.println("   Array length: " + length);
        
        System.out.println("Step 3: Perform character swapping");
        for (int i = 0; i < length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[length - i - 1];
            charArray[length - i - 1] = temp;
            System.out.println("   Swap " + i + ": " + Arrays.toString(charArray));
        }
        
        String reversedString = new String(charArray);
        System.out.println("\nStep 4: Final Result");
        System.out.println("   Original: " + str);
        System.out.println("   Reversed: " + reversedString);
        System.out.println();
    }
    
    // ==================== 2. FIND LONGEST STRING OPERATION ====================
    private static void demonstrateLongestString(List<String> fruits) {
        System.out.println("2. FIND LONGEST STRING OPERATION");
        System.out.println("=".repeat(50));
        
        System.out.println("Input list: " + fruits);
        
        // Step-by-step explanation for finding longest string
        System.out.println("\nStep-by-step longest string finding:");
        
        System.out.println("Step 1: Convert list to stream");
        Stream<String> fruitStream = fruits.stream();
        
        System.out.println("Step 2: Apply max() with length comparator");
        System.out.println("   Comparing strings by their length");
        
        System.out.println("Step 3: Handle Optional result");
        Optional<String> longestOptional = fruits.stream()
                .max(Comparator.comparingInt(String::length));
        
        System.out.println("Step 4: Extract and display result");
        if (longestOptional.isPresent()) {
            String longest = longestOptional.get();
            System.out.println("   Longest string: " + longest);
            System.out.println("   Length: " + longest.length());
        }
        
        // Alternative approaches
        System.out.println("\nAlternative Approaches:");
        
        // Using reduce
        String longestReduce = fruits.stream()
                .reduce("", (s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
        System.out.println("   Using reduce(): " + longestReduce);
        
        // Using sorted and findFirst
        String longestSorted = fruits.stream()
                .sorted((s1, s2) -> Integer.compare(s2.length(), s1.length()))
                .findFirst()
                .orElse("No strings found");
        System.out.println("   Using sorted(): " + longestSorted);
        System.out.println();
    }
    
    // ==================== 3. COMBINE LISTS OPERATION ====================
    private static void demonstrateCombineLists(List<Integer> list1, List<Integer> list2) {
        System.out.println("3. COMBINE LISTS OPERATION");
        System.out.println("=".repeat(50));
        
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        
        // Step-by-step explanation for combining lists
        System.out.println("\nStep-by-step list combination:");
        
        System.out.println("Step 1: Create streams from both lists");
        Stream<Integer> stream1 = list1.stream();
        Stream<Integer> stream2 = list2.stream();
        
        System.out.println("Step 2: Concatenate streams using Stream.concat()");
        Stream<Integer> combinedStream = Stream.concat(stream1, stream2);
        
        System.out.println("Step 3: Convert to int array using mapToInt()");
        int[] combinedArray = combinedStream
                .mapToInt(Integer::intValue)
                .toArray();
        
        System.out.println("Step 4: Display combined result");
        System.out.println("   Combined array: " + Arrays.toString(combinedArray));
        
        // Different combination variants
        System.out.println("\nDifferent Combination Variants:");
        
        // With duplicates removed
        int[] uniqueCombined = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println("   Unique elements: " + Arrays.toString(uniqueCombined));
        
        // With sorting
        int[] sortedCombined = Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println("   Sorted combined: " + Arrays.toString(sortedCombined));
        
        // With sorting and duplicates removed
        int[] sortedUnique = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println("   Sorted unique: " + Arrays.toString(sortedUnique));
        System.out.println();
    }
    
    // ==================== 4. MERGE AND SORT ARRAYS OPERATION ====================
    private static void demonstrateMergeAndSortArrays(int[] a, int[] b) {
        System.out.println("4. MERGE AND SORT ARRAYS OPERATION");
        System.out.println("=".repeat(50));
        
        System.out.println("Array A: " + Arrays.toString(a));
        System.out.println("Array B: " + Arrays.toString(b));
        
        // Step-by-step explanation for merging arrays
        System.out.println("\nStep-by-step array merging:");
        
        System.out.println("Step 1: Create result array with combined length");
        int[] merged = new int[a.length + b.length];
        System.out.println("   Result array size: " + merged.length);
        
        System.out.println("Step 2: Copy elements from first array");
        for(int i = 0; i < a.length; i++) {
            merged[i] = a[i];
        }
        System.out.println("   After copying array A: " + Arrays.toString(merged));
        
        System.out.println("Step 3: Copy elements from second array");
        for(int i = 0; i < b.length; i++) {
            merged[i + a.length] = b[i];
        }
        System.out.println("   After copying array B: " + Arrays.toString(merged));
        
        System.out.println("\nStep 4: Sort the merged array using Bubble Sort");
        System.out.println("   Starting bubble sort algorithm...");
        bubbleSortWithSteps(merged);
        
        System.out.println("Step 5: Final sorted array");
        System.out.println("   Sorted merged array: " + Arrays.toString(merged));
        
        // Alternative sorting methods
        System.out.println("\nAlternative Sorting Methods:");
        
        int[] forSelectionSort = Arrays.copyOf(merged, merged.length);
        selectionSort(forSelectionSort);
        System.out.println("   Selection sort: " + Arrays.toString(forSelectionSort));
        
        int[] forInsertionSort = Arrays.copyOf(merged, merged.length);
        insertionSort(forInsertionSort);
        System.out.println("   Insertion sort: " + Arrays.toString(forInsertionSort));
        
        int[] builtInSort = Arrays.copyOf(merged, merged.length);
        Arrays.sort(builtInSort);
        System.out.println("   Arrays.sort(): " + Arrays.toString(builtInSort));
        
        // Merge with duplicates removed
        System.out.println("\nAdvanced: Merge with duplicate removal");
        int[] mergedUnique = mergeAndRemoveDuplicates(a, b);
        bubbleSort(mergedUnique);
        System.out.println("   Merged unique sorted: " + Arrays.toString(mergedUnique));
    }
    
    // ==================== HELPER METHODS ====================
    
    private static void bubbleSortWithSteps(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            System.out.println("   Pass " + (i + 1) + ": " + Arrays.toString(arr));
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
    private static void insertionSort(int[] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    
    private static int[] mergeAndRemoveDuplicates(int[] a, int[] b) {
        int[] temp = new int[a.length + b.length];
        int count = 0;
        
        // Copy all elements
        for(int value : a) temp[count++] = value;
        for(int value : b) temp[count++] = value;
        
        // Remove duplicates
        int uniqueCount = 0;
        for(int i = 0; i < count; i++) {
            boolean isDuplicate = false;
            for(int j = 0; j < uniqueCount; j++) {
                if(temp[i] == temp[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if(!isDuplicate) {
                temp[uniqueCount++] = temp[i];
            }
        }
        
        // Return only unique elements
        return Arrays.copyOf(temp, uniqueCount);
    }
}