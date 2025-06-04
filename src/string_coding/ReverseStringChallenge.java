package string_coding;

import java.util.stream.Stream;

public class ReverseStringChallenge {

    public static void main(String[] args) {

        String str = "hello";
        System.out.println("#######  Approach 1 #####");
       //  Approach 1
        char[] chArr = str.toCharArray();
        for (int i = chArr.length - 1; i >= 0; i--) {
            System.out.println(chArr[i]);
        }
        System.out.println("#######  Approach 2 #####");
        // Approach 2
        for(int i = str.length() - 1; i >= 0; i--) {
            System.out.println(str.charAt(i));
        }
        System.out.println("######  Approach 3 ######");
        // Approach 3
        StringBuffer sb = new StringBuffer(str);
        System.out.println(sb.reverse());

        System.out.println("######  Approach 4  ######");

        // Approach 4
        StringBuilder sb1 = new StringBuilder(str);
        System.out.println(sb1.reverse());

        System.out.println("######  Approach 5 ######");

        // Approach 5
        String rev = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        System.out.println(rev);


        System.out.println("######  Approach 6  ######");

        // Approach 6
        Stream<String > revStream = Stream.of(str.split("")).reduce((s1, s2) -> s2 + s1).get().lines();
        revStream.forEach(System.out::println);


        }

}
