package coding;

import array.ArrayUtility;

public class FindMaximumNumber {
    public static void main(String[] args) {
        int[] arr = ArrayUtility.inputArray();

        int max = findMaximum(arr, 0);
        System.out.println("Maximum number in the array: " + max);
    }

    public static int findMaximum(int[] arr, int index) {
        // Base case: If we've reached the end of the array, return the last element
        if (index == arr.length - 1) {
            return arr[index];
        }

        // Recursive case: Find the maximum in the rest of the array
        int maxInRest = findMaximum(arr, index + 1);
        // Return the maximum between the current element and the maximum found in the rest
        return Math.max(arr[index], maxInRest);
    }
}
