package com.rizvi.exception;

import java.util.Scanner;

public class ExceptionDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            int a, b;

            // Get input from command line arguments if available, otherwise from user
            if (args.length >= 2) {
                a = Integer.parseInt(args[0]);
                b = Integer.parseInt(args[1]);
            }
            else {
                System.out.print("Enter first number (a): ");
                a = scanner.nextInt();
                System.out.print("Enter second number (b): ");
                b = scanner.nextInt();
            }

            int c = a / b;
            System.out.println("c = " + c);

        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception occurred...!");
            System.out.println("Please enter a non-zero value for b");

        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception occurred...!");
            System.out.println("Please enter the input in number format.");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException occurred...!");
            System.out.println("Please enter 2 inputs from command line.");

        } catch (Exception e) {
            System.out.println("This catch block executes when we get an exception other than above mentioned exceptions...!");
            System.out.println("Exception: " + e.getMessage());

        } finally {
            scanner.close();
            System.out.println("Program execution completed.");
        }
  }
}
