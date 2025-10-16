package coding;

public class ReverseStringWithStreamMethods {

    public static void main(String[] args) {

        String str = "Hello World";
        String reversedStr = new StringBuilder(str).reverse().toString();
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reversedStr);


        // by using stream api
        String reversedStrStream = str.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
        System.out.println("Reversed String using Stream API(approach 1): " + reversedStrStream);

        // another approach using stream api
        String reversedStrStream2 = str.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .reduce("", (s1, s2) -> s2 + s1);
        System.out.println("Reversed String using Stream API (approach 2): " + reversedStrStream2);
    }
}
