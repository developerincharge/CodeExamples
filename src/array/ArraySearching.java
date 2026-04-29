package array;

import java.util.Scanner;

public class ArraySearching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {3, 6, 8, 87, 65, 4, 9, 68, 98, 34};
        System.out.print("Enter the element to search: ");
        int num = sc.nextInt();
        boolean found = isFound(arr, num);

        if (found) {
            System.out.println("Element "+num+" found in the array." );
        } else {
            System.out.println("Element "+num+" not found in the array.");
        }

    }

    public static boolean isFound(int[] arr, int num) {
        int index = 0;
         while (index  < arr.length) {
            if (arr[index] == num) {
                return true; // Target element found in the array
            }
             index++;
        }
        return false;  // Target element not found in the array
    }

}
