package coding;

public class RemoveWhiteSpace {

    public static void main(String[] args) {

        String str = "  Hello   World  ";
        System.out.println("Before Removing White Space : " + str);
        str = str.replaceAll("\\s", "");
        System.out.println("After Removing White Space : " + str);

        // another way to use builtin method
        String str2 = "  Hello   World  ";
        System.out.println("Before Removing White Space : " + str2);
        str2 = str2.replace(" ", "");
        System.out.println("After Removing White Space : " + str2);

        // another way to remove white space using trim() method
        String str3 = "  Hello   World  "; // removes trailing spaces after World
        System.out.println("Before Removing White Space : " + str3);
        str3 = str3.trim(); // only removes leading and trailing spaces
        System.out.println("After Removing trailing Space using trim(): " + str3);

        // using string buffer class
        String str4 = "   Hello   World    "; // string with no spaces
        System.out.println("Before Removing White Space : " + str4);

        char[] str4Arr = str4.toCharArray(); // converts string into character array
        // created a string buffer object
        StringBuffer sb = new StringBuffer();
        // create object stringBuffer class and appending non-space characters array to it.
        for (int i = 0; i < str4Arr.length; i++) {
            if ((str4Arr[i] != ' ') && (str4Arr[i] != '\t') && (str4Arr[i] != '\n')) {
                sb.append(str4Arr[i]);
            }
        }
        String result = sb.toString();
        if (result.isEmpty()) {
            System.out.println("String contains only white spaces");
        } else {
            System.out.println("After Removing White Space using StringBuffer: " + sb);
        }
      }
    }