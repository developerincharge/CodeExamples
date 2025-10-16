package coding;

import java.util.ArrayList;
import java.util.List;

public class FindRepeatativeSting {

    public static void main(String[] args) {

        String str = "abcdeabcretgabcdpolasabcd";
        String longestRepetitiveSubstring = findLongestRepetitiveSubstring(str);
        List<Integer> indices = findAllOccurrences(str, longestRepetitiveSubstring);
        System.out.println("Longest repetitive substring: " + longestRepetitiveSubstring);
       // System.out.println("Occurrences at indices: " + indices);
    }

    private static String findLongestRepetitiveSubstring(String str) {

        int maxLength = 0;
        String result = "";

        for(int i = 0; i < str.length(); i++){
            for(int j = i + 1; j < str.length(); j++){
                String currentSubString = str.substring(i, j);

                // Check if the current substring appears again in the string
                if(str.indexOf(currentSubString, j) != -1){
                    // Update the result if this substring is longer than the previous one
                    if(currentSubString.length() > maxLength){
                        maxLength = currentSubString.length();
                        result = currentSubString;
                    }
                }
            }
        }


        return result;
    }


    private static List<Integer> findAllOccurrences(String str, String substring) {
        List<Integer> indices = new ArrayList<>();
        int index = str.indexOf(substring);
        while (index != -1) {
            indices.add(index);
            index = str.indexOf(substring, index + 1);
        }
        return indices;
    }
}
