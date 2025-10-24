package memorymangement;

class Person {
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class MemoryManagement {
    
    public static void main(String[] args) {
        int primitiveVariable1 = 10;
        Person personObj = new Person("John Doe", 45);
        String stringLiteral = "24";
        MemoryManagement memObj = new MemoryManagement();
        
        System.out.println("=== BEFORE memoryManagementTest CALL ===");
        System.out.println("primitiveVariable1: " + primitiveVariable1);
        System.out.println("personObj: " + personObj);
        System.out.println("stringLiteral: " + stringLiteral);
        System.out.println("stringLiteral identity: " + System.identityHashCode(stringLiteral));
        
        memObj.memoryManagementTest(personObj);
        
        System.out.println("\n=== AFTER memoryManagementTest CALL ===");
        System.out.println("personObj (in main): " + personObj);
        System.out.println("primitiveVariable1 (unchanged): " + primitiveVariable1);
    }

    private void memoryManagementTest(Person personObj) {
        System.out.println("\n=== INSIDE memoryManagementTest METHOD ===");
        
        // Reference copy - points to same object
        Person personObj2 = personObj;
        System.out.println("personObj2 (reference copy): " + personObj2);
        System.out.println("personObj == personObj2: " + (personObj == personObj2));
        
        // String literal - uses string pool
        String stringLiteral2 = "24";
        System.out.println("stringLiteral2: " + stringLiteral2);
        System.out.println("stringLiteral2 identity: " + System.identityHashCode(stringLiteral2));
        System.out.println("stringLiteral2 == \"24\": " + (stringLiteral2 == "24"));
        
        // New Person object creation
        Person anotherPersonObj = new Person("Jane Smith", 30);
        System.out.println("anotherPersonObj: " + anotherPersonObj);
        
        // New String object (not from pool)
        String stringLiteral3 = new String("24");
        System.out.println("stringLiteral3: " + stringLiteral3);
        System.out.println("stringLiteral3 identity: " + System.identityHashCode(stringLiteral3));
        System.out.println("stringLiteral2 == stringLiteral3: " + (stringLiteral2 == stringLiteral3));
        System.out.println("stringLiteral2.equals(stringLiteral3): " + stringLiteral2.equals(stringLiteral3));
        
        // Demonstrate object modification through reference
        System.out.println("\n--- Modifying personObj2 (affects original) ---");
        personObj2.age = 50;
        System.out.println("Modified personObj2 age to 50");
        System.out.println("personObj2: " + personObj2);
    }
}