package coding;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIntegerDemo {


    public static void main(String[] args) {
        // Input array of numbers
        int[] nums = {2, 3, 7, 9, 11, 15};

        // Target sum
        int target = 26;

        // Call the twoSums method to find the indices of the two numbers
        int[] result = twoSums(nums, target);

        // Check if a valid solution was found
        if (result.length == 2) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution found.");
        }
    }
    /**
     * Finds the indices of two numbers in the array that add up to the target.
     *
     * @param nums   The input array of integers.
     * @param target The target sum.
     * @return An array containing the indices of the two numbers, or an empty array if no solution is found.
     */


    // Method to find the indices of two numbers in the array that add up to the target
    private static int[] twoSums(int[] nums, int target) {
        // Create a HashMap to store the difference between the target and each number, along with its index
        Map<Integer, Integer> numToIndexMap = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement (the number needed to reach the target)
            int complement = target - nums[i];

            // Check if the complement is already in the map
            if (numToIndexMap.containsKey(complement)) {
                // If found, return the current index and the index of the complement
                return new int[]{numToIndexMap.get(complement), i};
            }

            // If the complement is not found, add the current number and its index to the map
            numToIndexMap.put(nums[i], i);
        }
        // If no solution is found, return an empty array
        return new int[0];
    }

}
