package coding;

import java.util.HashSet;
import java.util.stream.Stream;

public class FindMissingNumberDemo {

    public static void main(String[] args) {

        int a[] = {1,2,5,7,8,10,12,13,14,15,16,17,18,19,20};
        missingNumbers(a);

    }

    private static void missingNumbers(int a[]) {

        HashSet<Integer> set = new HashSet<>();

        for( int num : a){
            set.add(num);
            Stream.of(num).forEach(s -> System.out.print(" "+ num));

        }
        System.out.println();
        int n = a.length +1;
        for(int i =0; i < n; i++) {
            if(!set.contains(i)) {
                System.out.print("  "+i);
            }
        }
    }

}
