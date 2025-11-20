package string_coding;

import java.util.*;

public class LongestSubstring {
    public static void main(String[] args) {
        String input = "abcabcbb";
        int result = lengthOfLongestSubstring(input);
        
        System.out.println("Input: \"" + input + "\"");
        System.out.println("Output: " + result);
        System.out.println("Explanation: The answer is \"abc\", with the length of " + result);
    }
    
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If character is already in the set, move left pointer
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }
            
            // Add current character to set
            set.add(currentChar);
            
            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}