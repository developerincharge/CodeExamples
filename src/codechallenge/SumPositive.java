package codechallenge;

import array.ArrayUtility;

import java.util.Scanner;

public class SumPositive {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
         int[] mumArr = ArrayUtility.inputArray();
        System.out.println("Enter a positive or negative integer: ");

       int sumOfPositiveNumbers = 0;
       for (int num : mumArr) {
              if (num < 0) {
               continue;
              }
                sumOfPositiveNumbers += num;
         }
          System.out.println("The sum of positive numbers in the array is: " + sumOfPositiveNumbers);

      }
}
