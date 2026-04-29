package codechallenge;

import java.util.Scanner;

public class PrintTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to multiply: ");
        int num = sc.nextInt();

        printMultiplicationTable(num);
        System.out.println("Multiplication Table of " + num + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    sc.close();
    }

    // create a method for  the multiplication table
    public static void printMultiplicationTable(int num) {
         System.out.println("Multiplication Table of " + num + ":");
         for (int i = 1; i <= 10; i++) {
             System.out.println(num + " x " + i + " = " + (num * i));
         }

//        int i = 1;
//        System.out.println("Multiplication Table of " + num + ":");
//        while (i <= 10) {
//            System.out.println(num + " x " + i + " = " + (num *  i));
//            i++;
//        }
    }
}
