package stream;

public class StreamMethodDemo {

    public static void main(String[] args) {


        String message1 = "Hello, Java!";
        String message2 = "hello, java!";

        int length = message1.length();
        System.out.println(length);

        char firstCharacter = message1.charAt(0);
        System.out.println(firstCharacter);

        String greeting = message1.concat(" Welcome to Programming.");
        System.out.println(greeting);

        boolean isEqual = message1.equals(message2);
        System.out.println(isEqual);

        boolean containsWord = message1.contains("Java");
        System.out.println(containsWord);




    }
}
