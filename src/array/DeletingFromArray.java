package array;

import java.util.Scanner;

public class DeletingFromArray {
    public static void main(String[] args) {
        Scanner  input = new Scanner(System.in);

        int[] numArr = ArrayUtility.inputArray();
        System.out.print("Enter number for deletion: ");
        int numToDelete = input.nextInt();

        System.out.println("Original array before :");
        ArrayUtility.displayArray(numArr);
        System.out.println();

        int[] newArr = deleteFromArray(numArr, numToDelete);
        System.out.println("New Array after deletion:");
            ArrayUtility.displayArray(newArr);
    }

    public static int[] deleteFromArray(int[] numArr, int numToDelete) {
//        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == numToDelete) {
//                count++;
//            }
//        }
//
//        if (count == 0) {
//            System.out.println("Number not found in the array.");
//            return arr;
//        }
//
//        int[] newArr = new int[arr.length - count];
//        int index = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != numToDelete) {
//                newArr[index++] = arr[i];
//            }
//        }
//        return newArr;

        int occ = OccurancesInArray.noOfOccurences(numArr, numToDelete);
        if(occ == 0){
            return numArr;
        }
        int newSize = numArr.length - occ;
        int[] newArr = new int[newSize];

        int i = 0,  j =0;
        while(i < numArr.length){
            if(numArr[i] != numToDelete){
                newArr[j] = numArr[i];
                j++;
            }
            i++;
        }
      return newArr;
    }
}
