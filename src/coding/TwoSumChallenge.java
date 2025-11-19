package coding;

public class TwoSumChallenge {

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

    // Method to find the indices of two numbers using two loops that add up to the target
    public static int[] twoSums(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
                System.out.println(" "+nums[i]+" "+nums[j]);
            }
        }
        return new int[]{};
    }

}







