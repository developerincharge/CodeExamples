package codechallenge;

import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = sc.nextInt();

            if (isArmstrong(num)) {
                System.out.println(num + " is an Armstrong number.");
            } else {
                System.out.println(num + " is not an Armstrong number.");
            }
    }

    public static boolean  isArmstrong(int num) {
        int digits = noOfDigits(num);
        int numCopy = num; // Copy of original number for comparison later
        int finalNumber = 0;
        while(num > 0){
            int lastDigit = num % 10;
            num /= 10; // Remove last digit
            finalNumber += power(lastDigit, digits);
        }
        return finalNumber == numCopy;
    }

    public static int power(int base, int exp) {
        int result = 1;
        int i = 0;
          while(i < exp){
            result *= base;
            i++;
          }
        return result;
    }

    public static int noOfDigits(int num) {
        int digits = 0;
        while (num > 0) {
            digits++;
            num /= 10; // Remove last digit
        }
        return digits;
    }
}
