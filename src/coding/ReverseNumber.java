package coding;

import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");

        // using alogrithm

         int num = sc.nextInt();

//        int rev = 0;
//        while (num != 0) {
//            int digit = num % 10;
//            rev = rev * 10 + digit;
//            num = num / 10;
//        }
      //  Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());

        // using StringBuffer class


//        String str = Integer.toString(num);
//        StringBuffer sb = new StringBuffer(str);
//        sb.reverse();
//        int rev = Integer.parseInt(sb.toString());


        // using StringBuilder class


//        StringBuilder sb = new StringBuilder(String.valueOf(num));
//        StringBuilder rev = sb.reverse();


        //  Using appemd method

//        StringBuilder sb = new StringBuilder();
//        sb.append(num);
//        StringBuilder rev = sb.reverse();

        // Stream API

       int rev = Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());



       System.out.println("Reversed number: "+  rev);


    }


}
