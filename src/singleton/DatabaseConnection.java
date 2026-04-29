package singleton;

public class DatabaseConnection {

    // Single instance
    private static DatabaseConnection instance = null;

    // Connection properties
    private String host;
    private int port;
    private String dbName;
    private boolean isConnected;

    // Private constructor
    private DatabaseConnection() {
        this.host        = "localhost";
        this.port        = 5432;
        this.dbName      = "my_database";
        this.isConnected = true;
        System.out.println("🔌 Opening NEW Database Connection...");
    }

    // Get the one and only instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else {
            System.out.println("♻️  Reusing EXISTING Database Connection...");
        }
        return instance;
    }

    // Execute a query
    public String query(String sql) {
        if (isConnected) {
            return "Executing: '" + sql + "' on " + dbName;
        }
        return "Not connected!";
    }

    public void disconnect() {
        isConnected = false;
        System.out.println("❌ Database Disconnected!");
    }

    @Override
    public String toString() {
        return "DB Connection → Host:" + host + " Port:" + port + " DB:" + dbName;
    }

    // --- Main Method to Test ---
    public static void main(String[] args) {

        System.out.println("=== App Module 1 (User Service) ===");
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        System.out.println(db1);
        System.out.println(db1.query("SELECT * FROM users"));

        System.out.println("\n=== App Module 2 (Order Service) ===");
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        System.out.println(db2);
        System.out.println(db2.query("SELECT * FROM orders"));

        System.out.println("\n=== App Module 3 (Product Service) ===");
        DatabaseConnection db3 = DatabaseConnection.getInstance();
        System.out.println(db3.query("SELECT * FROM products"));

        System.out.println("\n=== Proof: All the SAME Object ===");
        System.out.println("db1 == db2 : " + (db1 == db2));   // true ✅
        System.out.println("db2 == db3 : " + (db2 == db3));   // true ✅
    }
}