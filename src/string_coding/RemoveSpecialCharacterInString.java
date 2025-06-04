package string_coding;

public class RemoveSpecialCharacterInString {

    public static void main(String[] args) {

        String str = "$ja!va$&st%ar";

        // Approach 1  [ replaceAll() ]
        String platStr =  str.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(platStr);






    }
}
