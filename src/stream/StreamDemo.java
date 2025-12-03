package stream;

public class StreamDemo {

    public static void main(String[] args) {


        String text = "Java Programming!";
        String upperCase = text.toUpperCase();
        System.out.println("Upper Case : "+upperCase);

        String lowerrCase = text.toLowerCase();
        System.out.println("Lower Case : "+lowerrCase);

        String substring = text.substring(0,4);
        System.out.println("Substring : "+substring);

        String substring2 = text.substring(5);
        System.out.println("Substring fro index 5:  "+substring2);



    }
}
