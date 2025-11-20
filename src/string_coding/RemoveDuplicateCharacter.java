package string_coding;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateCharacter {
    public static void main(String[] args) {

        // approach 1

        String str = "programming";
        StringBuilder sb1 = new StringBuilder();
        //str.chars().distinct().forEach(sb1::append);
        str.chars().distinct().forEach(c -> sb1.indexOf(String.valueOf((char) c)));
        //str.chars().distinct().forEach(c -> sb1.append((char) c));
        System.out.println(sb1);



        // approach 2

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
          int idx = str.indexOf(ch, i + 1);
            if (idx == -1) {
                sb2.append(ch);
            }
        }
        System.out.println(sb2);


        // approach 3

        StringBuilder sb3 = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!sb3.toString().contains(String.valueOf(ch))) {
                sb3.append(ch);
            }
        }
        System.out.println(sb3);

        // approach 4

        char[] arr = str.toCharArray();
        StringBuilder sb4 = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
           boolean repeated = false;
             for ( int j = i + 1; j < arr.length; j++) {
                 if (arr[i] == arr[j]) {
                     repeated = true;
                     break;
                 }
             }
             if(!repeated){
                 sb4.append(arr[i]);
             }
          }
        System.out.println(sb4);

        // approach 5

  char[] chArr = str.toCharArray();
        StringBuilder sb5 = new StringBuilder();
        for (char ch : chArr) {
            if (!sb5.toString().contains(String.valueOf(ch))) {
                sb5.append(ch);
            }
        }
        System.out.println(sb5);


        // approach 6

        StringBuilder sb6 = new StringBuilder();
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        for (Character ch : set) {
            sb6.append(ch);
        }
        System.out.println(sb6);









    }
}
