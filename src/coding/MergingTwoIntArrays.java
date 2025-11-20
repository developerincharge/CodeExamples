package coding;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergingTwoIntArrays {
    public static void main(String[] args) {
        int [] a = {1, 2, 3, 4, 5, 6, 7};
        int [] b = {4, 5, 6, 7, 8, 9, 10};

        // declare a new int array
        int [] c = new int[a.length + b.length];  //  this is now  3 + 3 = 6

        for(int i = 0; i < a.length; i++){
            c[i] = a[i];  // this will store until 3 indexes {1, 2, 3, 0, 0, 0}
        }
        for( int i =0; i < b.length; i++){
            c[i + a.length] = b[i];  // this will pass the first three index the store
        }
        System.out.println(Arrays.toString(c));

        // merge the tow array using IntStream
        int [] d = IntStream.concat(Arrays.stream(a), Arrays.stream(b))
                .distinct()
                .toArray();
        System.out.println(Arrays.toString(d));
    }
}
