package coding;

import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");

        int num = sc.nextInt();
        int reverse = reverseNumber(num);
        System.out.println("Reversed of number: " + reverse);


        // using algorithm

//        int rev = 0;
//        while (num != 0) {
//            int digit = num % 10;
//            rev = rev * 10 + digit;
//            num /= 10;
//        }


        // using StringBuffer class

//        String str = Integer.toString(num);
//        StringBuffer sb = new StringBuffer(str);
//        sb.reverse();
//        int rev = Integer.parseInt(sb.toString());


        //  Using appemd method

//        StringBuilder sb = new StringBuilder();
//        sb.append(num);
//        StringBuilder rev = sb.reverse();

        // using StringBuilder class

        StringBuilder sb = new StringBuilder(String.valueOf(num));
        StringBuilder rev = sb.reverse();

        // Stream API

      //  int rev =  Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());


        System.out.println("Reversed number: "+ rev);


    }
      public static int reverseNumber(int num) {
          int reverse = 0;
          while (num > 0) {
              int digit = num % 10;
              reverse = reverse * 10 + digit;
              num /= 10;
          }
          return reverse;
      }

}
