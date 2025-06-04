package string_coding;

public class ReverseEachWord {
    public static void main(String[] args) {


          String str = "hello world Java code";

        System.out.println("Original String: " + str);

          // Approach 1

          String[] words = str.split(" ");
          StringBuilder sb = new StringBuilder();
          for (String word : words) {
              sb.append(new StringBuilder(word).reverse().toString() + " ");
          }
          System.out.println("Reversed String: "+sb.toString().trim());


          // Approach 2

          String[] words1 = str.split(" ");
          StringBuilder sb1 = new StringBuilder();
          for (int i = words1.length-1; i >= 0; i--) {
              sb1.append(words1[i] + " ");
          }
          System.out.println("Reversed String: "+sb1.toString().trim());


          // Approach 3
           String reversedString = "";

          String[] words2 = str.split(" ");

          for (String word : words2) {
              String revWords = "";
              for (int i = word.length() - 1; i >= 0; i--) {
                  revWords = revWords + word.charAt(i);
              }
              reversedString = reversedString + revWords + " ";
             }
            System.out.println("Reversed String: "+reversedString);



    }

}
