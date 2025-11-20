package coding;

import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");

        int num = sc.nextInt();

        // using algorithm

        int rev = 0;
        while (num != 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num = num / 10;
        }


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

//        StringBuilder sb = new StringBuilder(String.valueOf(num));
//        StringBuilder rev = sb.reverse();



        // Stream API

      //  int rev =  Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());



        System.out.println("Reversed number: "+ rev);


    }


}
