package codechallenge;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to find up to in Fibonacci series : ");
        int num = sc.nextInt();
        System.out.println("Here is Fibonacci Series to this number: " + num);
          printFibonacci(num);

    }

    public static void printFibonacci(int n) {
//        if (n <= 0) return 0;
//        if (n == 1) return 1;
//
//        long a = 0, b = 1, c = 0;
//        for (int i = 2; i <= n; i++) {
//            c = a + b;
//            a = b;
//            b = c;
//        }
//        return c;
//    }

        if(n < 0) return;
        System.out.print("0 ");
        if(n == 0) return;
        System.out.println("1 ");
        int first = 0, second = 1;

          while (first + second <= n) {
                int third = first + second;
                if (third > n) break;
                System.out.print(third + " ");
                first = second;
                second = third;
          }



    }
}
