package coding;

import array.ArrayUtility;

import java.util.Scanner;

public class OccurrencesForEach {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] nums = ArrayUtility.inputArray();
        System.out.print("Enter the number to search for: ");
        int element = input.nextInt();

        int occurrences = countOccurrences(nums, element);
        System.out.println("Occurrences of " + element + " in the array is " + occurrences+" times");

    }

    private static int countOccurrences(int[] nums, int element) {
        int occ = 0;
        for (int num : nums) {
            if (num == element) {
                occ++;
            }
        }
        return occ;

    }
}
