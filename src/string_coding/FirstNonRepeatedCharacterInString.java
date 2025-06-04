package string_coding;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharacterInString {
    public static void main(String[] args) {
        String str = "AABCDBECF";

        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (str.indexOf(ch) == str.lastIndexOf(ch)) {
                System.out.println(ch);
                break;
            }
        }

        System.out.println("##########");

         //    Approach 2
        for(int i = 0; i < str.length( ); i++) {
                boolean unique = true;
            for(int j = 0; j < str.length(); j++) {
               if( str.charAt(i) == str.charAt(j) && i != j) {
                   unique = false;
                   break;
               }
            }
               if(unique) {
                   System.out.println(str.charAt(i));
                   break;
            }
        }

        System.out.println("########");



        //  Approach 3

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(map.containsKey(ch)) {
              map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

           System.out.println("Actual map : "+map);  // print the map

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                System.out.println(entry.getKey());
                break;
            }
        }





    }

}
