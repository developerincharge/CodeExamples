package controlstatements;

import java.util.Scanner;

public class TernaryOperator {

    public static void main(String[] args) {

     Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int firstNumber = input.nextInt();
        System.out.print("Enter second number: ");
        int secondNumber = input.nextInt();

       // int maxNumber = (firstNumber > secondNumber) ? firstNumber : secondNumber;
        int minNumber =  (firstNumber < secondNumber) ? firstNumber : secondNumber;

//        int maxNumber;
//        if (firstNumber > secondNumber) {
//            maxNumber = firstNumber;
//        } else{
//               maxNumber = secondNumber;
//        }
    //    System.out.println("The Maximum number is  :"+maxNumber);
        System.out.println("The Minimum number is  :"+minNumber);
    }
}
