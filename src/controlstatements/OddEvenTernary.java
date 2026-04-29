package controlstatements;

import java.util.Scanner;

public class OddEvenTernary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        String oddEven = num % 2 == 0 ? "Even" : "Odd";
        System.out.println(num + " is " + oddEven);
    }
}
