package codechallenge;

import java.util.Scanner;

public class OddSum {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
        System.out.println("Enter a positive integer: ");
        int n = input.nextInt();

        int sum = sumOddNumbers(n);
        System.out.println("The sum of odd numbers from 1 to " + n + " is: " + sum);

    }
      public static int sumOddNumbers(int num) {
          int sum = 0;


//          for (int i = 1; i <= n; i++) {
//              if (i % 2 != 0) { // Check if the number is odd
//                  sum += i; // Add the odd number to the sum

          int i = 1;
          while (i <= num) {

                  sum += i;   // Add the odd number to the sum
                   i += 2 ;// add 2 to the number is make it odd
              }
              return sum;


      }
}
