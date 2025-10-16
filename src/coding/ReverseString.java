package coding;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to reverse: \n");
        String str = scanner.nextLine();


        // By using character array
        char[] charArray = str.toCharArray();  // convert string  into character array
        int length = charArray.length;
         reverseString(charArray, length);
        //System.out.println("Reversed string: " + new String(charArray));
        System.out.println("Reversed string: " + Arrays.toString(charArray));

      }


        public static void reverseString(char[] charArray, int length) {

        // Using recursive approach

//        if(length > 0){
//            System.out.println(charArray[length -1]);
//            length--;
//            // recursive calling method
//            reverseString(charArray, length);
//        }

        // Using algorithm

        for (int i = 0; i < length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[length - i - 1];
            charArray[length - i - 1] = temp;
        }

            // Using StringBuilder class
           // String str;
//        StringBuilder sb = new StringBuilder();
//        StringBuilder rev = sb.reverse();
        //System.out.println("Reversed string: " + rev);

    }
}
