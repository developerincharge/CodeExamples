package string_coding;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacter {
    public static void main(String[] args) {

        LengthOfLongestSubString("abcabcdbb");
    }
    public static void LengthOfLongestSubString(String s){
     String longestSubString = null;
     int longestSubstringLength = 0;

        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] arr = s.toCharArray();

        for(int i =0;  i < arr.length; i++){
            char ch = arr[i];

            if(!map.containsKey(ch)){
               map.put(ch, i);
            }else {
                i = map.get(ch);
                map.clear();
            }
            if(map.size() > longestSubstringLength){
                longestSubstringLength = map.size();
                longestSubString = map.keySet().toString();

            }
        }

        System.out.println("The Longest substring :  "+ longestSubString);
        System.out.println("The Longest Substring Length :  "+ longestSubstringLength);


    }
}
