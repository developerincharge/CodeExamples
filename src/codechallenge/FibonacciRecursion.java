package codechallenge;

import java.util.Scanner;

public class FibonacciRecursion {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Fibonacci Sequence using Recursion");

        System.out.print("Enter the number of Fibonacci terms to display: ");
        System.out.println("\n" + "=".repeat(50));
        int count = input.nextInt();

        for (int i = 1; i <= count; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int position) {
        System.out.print(".");
        if (position == 1) {
            return 0;
        }
        if (position == 2 ) {
            return 1;
        }
        // Recursive call for the previous two Fibonacci numbers
        return fibonacci(position - 1)
                + fibonacci(position - 2);
    }
}
