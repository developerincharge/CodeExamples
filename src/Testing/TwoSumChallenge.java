package Testing;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumChallenge {
    /**
     * Finds the indices of two numbers in the array that add up to the target.
     *
     * @param arr   The input array of integers.
     * @param target The target sum.
     * @return An array containing the indices of the two numbers, or an empty array if no solution is found.
     */

    public static int[] findTwoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                return new int[] {
                        map.get(complement), i
                };
            }
            map.put(arr[i], i);
        }

        return new int[] {-1, -1}; // No solution found
    }

    public static void main(String[] args) {
        // Test Case 1: Your example
        int[] arr1 = {-1, 0, 2, 1, 4};
        int target1 = 0;
        testTwoSum(arr1, target1);

        // Test Case 2: Basic case
        int[] arr2 = {2, 7, 11, 15};
        int target2 = 9;
        testTwoSum(arr2, target2);

        // Test Case 3: Negative numbers
        int[] arr3 = {-3, 4, 3, 90};
        int target3 = 0;
        testTwoSum(arr3, target3);

        // Test Case 4: No solution
        int[] arr4 = {1, 2, 3, 4};
        int target4 = 10;
        testTwoSum(arr4, target4);

        // Test Case 5: Duplicate values
        int[] arr5 = {3, 3, 4, 5};
        int target5 = 6;
        testTwoSum(arr5, target5);
    }

    public static void testTwoSum(int[] arr, int target) {
        int[] result = findTwoSum(arr, target);

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);

        if (result[0] != -1 && result[1] != -1) {
            System.out.println("Indices: (" + result[0] + ", " + result[1] + ")");
            System.out.println("Values: " + arr[result[0]] + " + " + arr[result[1]] +
                    " = " + (arr[result[0]] + arr[result[1]]));
        } else {
            System.out.println("No solution found");
        }
        System.out.println();
    }
}