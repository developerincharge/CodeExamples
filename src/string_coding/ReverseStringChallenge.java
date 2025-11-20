package string_coding;

import java.util.stream.Stream;

public class ReverseStringChallenge {

    public static void main(String[] args) {

        String str = "hello world";
        System.out.println("#######  Approach 1 #####");
       //  Approach 1
        char[] chArr = str.toCharArray();
        for (int i = chArr.length - 1; i >= 0; i--) {
            System.out.print(chArr[i]);

        }
        System.out.println();
        System.out.println("#######  Approach 2 #####");
        // Approach 2
        for(int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
        System.out.println("######  Approach 3 ######");
        // Approach 3
        StringBuffer sb = new StringBuffer(str);
        System.out.println(sb.reverse());

        System.out.println("######  Approach 4  ######");
        // Approach 4
//        StringBuilder sb1 = new StringBuilder(str);
//        System.out.println(sb1.reverse());
        String reversedStr = new StringBuilder(str).reverse().toString();
        System.out.println("Original String: " + str);
        System.out.println("Reversed using StringBuilder and Stream API(approach 4):  " + reversedStr);

        System.out.println();
        System.out.println("######  Approach 5 ######");
        // Approach 5
        String rev = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            rev +=  str.charAt(i);
        }
        System.out.println(rev);

        System.out.println("######  Approach 6  ######");

        // Approach 6
        Stream<String > revStream = Stream.of(str.split("")).reduce((s1, s2) -> s2 + s1).get().lines();
        revStream.forEach(System.out::println);

        System.out.println("######  Approach 7  ######");
        // by using stream api
        String reversedStrStream = str.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
        System.out.println("Reversed String using Stream API(approach 7): " + reversedStrStream);


        System.out.println("######  Approach 8  ######");
        // another approach using stream api
        String reversedStrStream2 = str.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .reduce("", (s1, s2) -> s2 + s1);
        System.out.println("Reversed String using Stream API (approach 8): " + reversedStrStream2);



        }

}
