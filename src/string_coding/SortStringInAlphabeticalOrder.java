package string_coding;

import java.util.Arrays;

public class SortStringInAlphabeticalOrder {
    public static void main(String[] args) {

        String str = "rock";
        // approach 1 without using sort()
        char arr[] = str.toCharArray();
        char temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(new String(arr));

        System.out.println("########");
        // Approach 2

        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        System.out.println(new String(charArray));

    }
}
