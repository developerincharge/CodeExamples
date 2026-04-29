package array;

import java.util.Scanner;

public class ArrayUtility {

    public static int[] inputArray() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the elements size of the array: ");
        int size = input.nextInt();
        int[] nums = new int[size];
        int i = 0;
        while(i < size){
            System.out.print("Please enter the element no at index " + (i+1) + ": ");
            nums[i] = input.nextInt();
            i++;
        }
        return nums;
    }

    public static int[][] input2DArray() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the elements size of the rows: ");
        int rows = input.nextInt();
        System.out.println("Please enter the elements size of the columns: ");
        int columns = input.nextInt();
        int[][] numArray = new int[rows][columns];

        int i = 0;
        while(i < rows){
                int j = 0;
                while(j < columns){
                    System.out.print("Please enter element rows  "
                            + (i+1) + " and column : " + (j+1) + " : ");
                    numArray[i][j] = input.nextInt();
                    j++;
                }
            i++;
        }
        return numArray;
    }


    public static void displayArray(int[] numArray) {
        System.out.println("The elements of the array are: ");
          int i = 0;
          while (i < numArray.length) {
            System.out.print(numArray[i] + " ");
            i++;
        }
        System.out.println();
    }

    public static int[] removeFirstElement(int [] arr1){
        int [] arr2 = new int[arr1.length - 1];
        int i = 0;
        while(i < arr2.length){
            arr2[i] = arr1[i + 1];
            i++;
        }
        return arr2;
    }
}
