package string_coding;

public class RemoveAllWhiteSpaces {
    public static void main(String[] args) {

        String str =  "   j  a  va    i  s   go  o  d  p  r ogr  am  m  ing  lan g u age     ";

       String trimmedStr =  str.replaceAll("\\s", "");
        System.out.println(trimmedStr);
    }
}
