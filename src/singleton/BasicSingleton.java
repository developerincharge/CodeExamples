package singleton;

public class BasicSingleton {

    private static BasicSingleton instance = null;
    //private String value;

    // Private constructor
    private BasicSingleton() {
       // this.value = "I am the ONE and ONLY!";
        System.out.println("✅ Singleton instance CREATED!");
    }

    // Public method to get instance
    public static BasicSingleton getInstance() {
        if (instance == null) {
            instance = new BasicSingleton();
        } else {
            System.out.println("♻️  Returning EXISTING instance...");
        }
        return instance;
    }

//    public String getValue() {
//        return value;
//    }

    public static void main(String[] args) {
        System.out.println("=== Requesting Instance 1 ===");
        BasicSingleton obj1 = BasicSingleton.getInstance();

        System.out.println("=== Requesting Instance 2 ===");
        BasicSingleton obj2 = BasicSingleton.getInstance();

        System.out.println("=== Requesting Instance 3 ===");
        BasicSingleton obj3 = BasicSingleton.getInstance();

        // Proof they are the same object
        System.out.println("\n--- Proof ---");
        System.out.println("obj1 == obj2 : " + (obj1 == obj2));   // true ✅
        System.out.println("obj1 == obj3 : " + (obj1 == obj3));   // true ✅
    //    System.out.println("Value: " + obj1.getValue());
    }
}