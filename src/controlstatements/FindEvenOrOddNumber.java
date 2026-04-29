package controlstatements;

import java.util.Scanner;

public class FindEvenOrOddNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        findEvenOrOddNumber(number);
    }

    public static int findEvenOrOddNumber(int number) {
        int evenOdd = number % 2 == 0 ? 1 : -1; // Using ternary operator to determine even or odd
        if (evenOdd == 1) {
            System.out.println(number + " is an even number.");
        } else {
            System.out.println(number + " is an odd number.");
        }
        return evenOdd;
    }
}