package array;

import java.util.Scanner;

public class Search2DArray {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int[][] numAarr = ArrayUtility.input2DArray();
        System.out.println("Enter the number to search in the 2D array:");
        int num = input.nextInt();
            boolean isFound = search2DArray(numAarr, num);
            if(isFound){
                System.out.println(num + " is found in the 2D array.");
            } else {
                System.out.println(num + " is not found in the 2D array.");
            }

    }

    private static boolean search2DArray(int[][] arr, int target) {
       int i = 0;
         while(i < arr.length){
                int j = 0;
                while(j < arr[i].length){
                    if(arr[i][j] == target){
                        return true;
                    }
                    j++;
                }
                i++;
         }
        return false;
    }
}
