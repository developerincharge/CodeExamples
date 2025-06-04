package coding;

import java.util.ArrayList;
import java.util.List;

public class RepetitiveStringDemo {

    public static void main(String[] args) {

       // String str = "abcdefghiezedabcdefghifh";
        String str = "SyedghiSyededbcdSyedifph";
        String longestRepetitiveSubstring = findLongestRepetitiveSubstring(str);
        List<Integer> indices = findAllOccurrences(str, longestRepetitiveSubstring);
        System.out.println("Longest repetitive substring: " + longestRepetitiveSubstring);
        //System.out.println(str.substring(str.indexOf(longestRepetitiveSubstring), str.indexOf(longestRepetitiveSubstring) + longestRepetitiveSubstring.length()));
        System.out.println("Occurrences at indices: " + indices);
    }
    private static String findLongestRepetitiveSubstring(String str) {
        int maxLength = 0;
        String result = "";

        // Iterate over all possible substrings
        for(int i = 0; i < str.length(); i++) {
            for(int j = i+1; j < str.length(); j++) {
                // Extract the current substring
                String currentSubString = str.substring(i, j);
                // Check if the current substring appears again in the string
                if (str.indexOf(currentSubString, j) != -1) {
                    // Update the result if this substring is longer than the previous one
                    if(currentSubString.length() > maxLength) {
                        maxLength = currentSubString.length();
                        result = currentSubString;
                }
              }
            }
        }
        return result;

    }

     // To find the indices of the repetitive
    private static List<Integer> findAllOccurrences(String str, String substring) {
        List<Integer> indices = new ArrayList<>();
        int index = str.indexOf(substring);

        while (index != -1) {
            indices.add(index);
            index = str.indexOf(substring, index + 1); // Find the next occurrence
        }

        return indices;
    }
}
