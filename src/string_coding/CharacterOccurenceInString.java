package string_coding;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CharacterOccurenceInString {


    public static void main(String[] args) {
          String str = "helloworld is java";


          // Approach 1

        Map<Character, Integer> map = str
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors
                .toMap(c -> c, c -> 1, Integer::sum));
        System.out.println(map);

        System.out.println("###################################################################");

           // Approach 2

        Map<Character, Integer> map1 = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (!map1.containsKey(ch)) {
                map1.put(ch, 1);
            } else {
                map1.compute(ch, (k, value) -> value + 1);
            }
        }
        System.out.println(map);


    }
}
