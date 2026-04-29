package string_coding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int result = lengthOfLongestSubstring(str);
        String distinctChars = printDistinctCharacters(str);  // Fixed method name and passed str
        System.out.println("String: \"" + str + "\"");
        System.out.println("Length of longest substring without repeating characters: " + result);  // Fixed print
        System.out.println("Explanation: The length of the longest substring without repeating characters is: " + result);  // Fixed explanation
        System.out.println("Distinct characters are: " + distinctChars);
    }

    private static String printDistinctCharacters(String str) {
        List<Character> characters = new ArrayList<>();
        for (char c : str.toCharArray()) {  // Add characters from string
            characters.add(c);
        }
        // Use stream to get distinct characters without modifying list during iteration
        List<Character> distinct = characters.stream().distinct().toList();  // Collect to new list
        return distinct.toString();
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int max = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (seen.contains(c)) {
                seen.remove(s.charAt(left++));
            }
            seen.add(c);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}