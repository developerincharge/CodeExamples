package Testing;

import java.util.Scanner;

public class Reverse {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter numbers to reverse: ");
        int numbers = input.nextInt();
        int reversed = reverseInteger(numbers);
        System.out.println("Reverse of Number is : " + reversed);
    }

    private static int reverseInteger(int num) {

        int newNum = 0;
        while (num != 0) {
            int digit = num % 10; // Get the last digit
            newNum = newNum * 10 + digit; // Append the digit to the reversed number
            num /= 10; // Remove the last digit
        }
        return newNum;
    }

}
