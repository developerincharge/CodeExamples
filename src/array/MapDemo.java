package array;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {

        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Fred", "212-555-1515");
        phoneBook.put("Syed", "312-565-1212");
        phoneBook.put("Hassan", "412-222-1315");
        phoneBook.put("Nargis", "512-456-1715");
        phoneBook.put("Fatima", "612-333-2525");

        System.out.println("Phone List : "+phoneBook);

        String phoneNumber = phoneBook.get("Fred");
        System.out.println("Freds phone Number : "+phoneNumber);

        phoneBook.remove("Fatima");
        System.out.println(phoneBook);


    }
}
