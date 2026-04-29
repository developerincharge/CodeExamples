package coding;

import java.util.stream.IntStream;

public class FindPrimeNumberFrom1To100 {

    public static void main(String[] args) {

        IntStream.rangeClosed(1, 100)
                .filter(n -> n>1 && IntStream.rangeClosed(2, (int)Math.sqrt(n))
                        .noneMatch(i -> n % i == 0))
                .forEach(System.out::println);


//        int i, j, s;
//        for (i = 2; i < 100; i++) {
//            s = 0;
//            for (j = 2; j < i; j++) {
//                if (i % j == 0)
//                    s = 1;
//                break;
//            }
//            if (s == 0) {
//                System.out.print(" "+i);
//            }
//        }




    }
}
