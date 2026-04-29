package coding;

import array.ArrayUtility;

public class MaxNumberArray {
    public static void main(String[] args) {
        int[] arr = ArrayUtility.inputArray();
        int max = Integer.MIN_VALUE;
        for(int num : arr){
            if(num > max){
                max = num;
            }
        }
        System.out.println("Maximum number in the array is: " + max);

    }
}
