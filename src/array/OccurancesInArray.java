package array;

import java.util.Scanner;

public class OccurancesInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int[] numArr = ArrayUtility.inputArray();
        System.out.println("Enter the number to find its occurrences:");
        int numberToFind = input.nextInt();
        int occurrences = noOfOccurences(numArr, numberToFind);
        System.out.println("The number occurrences of " + numberToFind + " is "+ occurrences + "  times in the array.");

    }

    public static int noOfOccurences(int[] numArr, int num){
        int occ = 0;
        int i = 0;
        while(i < numArr.length){
            if(numArr[i] == num){
                occ++;
            }
            i++;
        }
        return occ;
    }


}
