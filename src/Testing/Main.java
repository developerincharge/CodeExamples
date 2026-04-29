package Testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main{


    public static void test() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));

           Iterator<String> iterator = list.iterator();
           while(iterator.hasNext()){
               String element = iterator.next();
               if(element.equals("a")){
                  iterator.remove();
               }
           }
        System.out.println(list);

    }
    public static void main(String[] args) {

       test();
    }
}
