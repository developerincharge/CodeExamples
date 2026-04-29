package olymorphismdemo;

import java.util.Scanner;

public class FunctionReturn {
    public static void main(String[] args) {
       greet();
       int firstNumber = readNumber() +1;
       int secondNumber = readNumber() +2;
       int sum = firstNumber + secondNumber;
       System.out.println("The sum of " + firstNumber + " and " + secondNumber + " is : " + sum);
    }
    public static void greet(){
          System.out.println("Welcome to Calculator !!");
    }

      public static int readNumber(){
          Scanner input = new Scanner(System.in);
          System.out.println("Enter a number : ");
            int number = input.nextInt();
            return number;

      }
}
