package coding;

public class TwoSumChallenge {

    public static void main(String[] args) {

        int[] nums = {2,7,11,15};
        int target = 26;

        int[] result = twoSums(nums, target);

        if (result.length == 2) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution found.");
        }


    }


    public static int[] twoSums(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
                System.out.println(" "+nums[i]+" "+nums[j]);
            }
        }
        return new int[]{};
    }

}







