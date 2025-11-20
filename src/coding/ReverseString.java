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


//        reverseString(charArray, length);

        System.out.print("String to Perform reverse: " + new String(charArray));
        System.out.println("\nOriginal character array: " + Arrays.toString(charArray));
//
//      }
//        public static void reverseString(char[] charArray, int length) {
//
//        // Using recursive approach
//        if(length > 0){
//            System.out.print(charArray[length -1]+"");
//            length--;
//            // recursive calling method
//            reverseString(charArray, length);
//        }


        // Using legacy algorithm approach

        for (int i = 0; i < length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[length - i - 1];
            charArray[length - i - 1] = temp;
        }

        String reversedString = new String(charArray);
        System.out.println("Reversed string: " + reversedString);


            // Using StringBuilder class approach
           // String str;
//        StringBuilder sb = new StringBuilder();
//        StringBuilder rev = sb.reverse();
//        System.out.println("Reversed string: " + rev);


        System.out.println("Reversed character array: " + Arrays.toString(charArray));
    }
}
