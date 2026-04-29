package Testing;

import java.util.Scanner;

public class LeapCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
          int input = sc.nextInt();
          if(input % 400 == 0 || (input % 4 == 0 && input % 100 != 0)) {
              System.out.println(input + " is a leap year.");
              } else {
              System.out.println(input + " is not leap year.");

          }

    }

}