package string_coding;

public class ReplaceCharacterOccurrenceInString {

    public static void main(String[] args) {

        String str = "SyedghiSyededbcdSyedifph";

        char charToReplace = 'S';

        System.out.println("###############");
        System.out.println(str);
        char charToReplaceWith = 's';
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == charToReplace) {
                sb.setCharAt(i, charToReplaceWith);
            }
        }
        System.out.println(sb);

        System.out.println("#####################");
           // checking the presence of char in string
         if (str.indexOf(charToReplace) == -1){
             System.out.println("Given character is not present in the string");

         }else {
             String newStr = str.replace(charToReplace, 'T');
             System.out.println(newStr);

         }

        System.out.println("#####################");
        // checking the presence of char in string
        if (str.indexOf(charToReplace) == -1){
            System.out.println("Given character is not present in the string");
            System.exit(0);
        }
        // logic to replace char occurrence in string


/*        char[] arr = str.toCharArray();
        int cnt = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == charToReplace) {
                arr[i] = String.valueOf(cnt).charAt(0);
                cnt++;
            }
        }
        System.out.println(Arrays.toString(arr));*/
          int cnt = 1;
        // logic to replace char occurrence in string
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (ch == charToReplace){
             str = str.replaceFirst(String.valueOf(charToReplace), String.valueOf(cnt));
                cnt++;
            }
        }
        System.out.println(str);


    }
}
