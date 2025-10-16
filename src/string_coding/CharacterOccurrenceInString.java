package string_coding;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CharacterOccurrenceInString {

    public static void main(String[] args) {
          //String str = "hello world in java and it is a great programming language";
          String str = "quick brown fox jumps over the lazy dog";
           str = str.replaceAll("\\s+", "");
        System.out.println("######################  First Approach  #####################################");
          // Approach 1

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.compute(ch, (k, value) -> value + 1);
            }
        }
        System.out.println(map);


        System.out.println("#####################  Second Approach   ####################################");


           // Approach 2

        Map<Character, Integer> map1 = str
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors
                        .toMap(c -> c, c -> 1, Integer::sum));
        System.out.println(map1);


    }
}
