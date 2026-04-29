package array;

public class MaxMinArray {
    public static void main(String[] args) {

        int[] numArr = ArrayUtility.inputArray();
        int min = min(numArr);
        System.out.println("Minimum value in the array: " + min);
        int max = max(numArr);
        System.out.println("Maximum value in the array: " + max);
    }

    public static int min(int[] arr){
//        int min = arr[0];
//        for(int i = 1; i < arr.length; i++){
//            if(arr[i] < min){
//                min = arr[i];
//            }
//        }
            int min = Integer.MAX_VALUE;
            int i = 0;
            while(i < arr.length){
                if(min > arr[i] ){
                   min =  arr[i] ;
                }
                i++;
            }
        return min;
    }

    public static int max(int[] arr){

//        int max = arr[0];
//        for(int i = 1; i < arr.length; i++){
//            if(arr[i] > max){
//                max = arr[i];
//            }
//        }


            if(arr.length == 0){
                return Integer.MIN_VALUE;
            }
            int max = arr[0];
            int i = 1;
            while(i < arr.length){
                if(max < arr[i] ){
                   max =  arr[i] ;
                }
                i++;
            }
          return max;
    }
}
