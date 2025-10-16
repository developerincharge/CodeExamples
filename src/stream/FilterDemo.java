package stream;

import java.util.Arrays;
import java.util.List;

public class FilterDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("SUCCESS", "PENDING", "FAILED", "FAILED");
        System.out.println("Failed transaction count = " + list.stream().filter((s)->s.equals("FAILED")).count());
    }
}
