package coding;

import java.util.Arrays;

public class SortIntegerArray {
    public static void main(String[] args) {

        int[] a = {4, 3 ,2 ,1};
        // logic to sort the array without using sort()
        // Approach 1
        for(int i =0; i < a.length; i ++){
           for(int j = i +1; j < a.length; j++){
               if(a[i] > a[j]){
                   int temp = a [i];
                   a[i] = a[j];
                   a[j] = temp;
               }
           }
        }
        System.out.println(Arrays.toString(a));

        // Approach 2  using sort()
        System.out.println("############");

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
