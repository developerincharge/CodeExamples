package singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.*;
import java.util.concurrent.*;

public class SingletonMain {
    
    // ========== SIMPLE SINGLETON (NOT THREAD-SAFE) ==========
    private static SingletonMain instance;
    private int value;
    
    private SingletonMain() {
        System.out.println("Singleton instance created!");
        value = 0;
    }
    
    // Not thread-safe - for demonstration only
    public static SingletonMain getInstance() {
        if(instance == null){
            instance = new SingletonMain();
        }
        return instance;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    // ========== THREAD-SAFE SINGLETON (METHOD SYNCHRONIZED) ==========
    private static class ThreadSafeSingleton {
        private static ThreadSafeSingleton instance;
        
        private ThreadSafeSingleton() {
            System.out.println("ThreadSafeSingleton instance created!");
        }
        
        // Synchronized method - thread-safe but slower
        public static synchronized ThreadSafeSingleton getInstance() {
            if (instance == null) {
                instance = new ThreadSafeSingleton();
            }
            return instance;
        }
    }
    
    // ========== DOUBLE-CHECKED LOCKING SINGLETON ==========
    private static class DoubleCheckedSingleton {
        private static volatile DoubleCheckedSingleton instance;
        
        private DoubleCheckedSingleton() {
            System.out.println("DoubleCheckedSingleton instance created!");
        }
        
        // Double-checked locking pattern
        public static DoubleCheckedSingleton getInstance() {
            if (instance == null) { // First check (no synchronization)
                synchronized (DoubleCheckedSingleton.class) {
                    if (instance == null) { // Second check (with synchronization)
                        instance = new DoubleCheckedSingleton();
                    }
                }
            }
            return instance;
        }
    }
    
    // ========== BILL PUGH (INNER CLASS) SINGLETON ==========
    private static class BillPughSingleton {
        private BillPughSingleton() {
            System.out.println("BillPughSingleton instance created!");
        }
        
        // Inner helper class - loaded only when getInstance() is called
        private static class SingletonHelper {
            private static final BillPughSingleton INSTANCE = new BillPughSingleton();
        }
        
        public static BillPughSingleton getInstance() {
            return SingletonHelper.INSTANCE;
        }
    }
    
    // ========== ENUM SINGLETON (BEST PRACTICE) ==========
    public enum EnumSingleton {
        INSTANCE;
        
        private int value;
        
        EnumSingleton() {
            System.out.println("EnumSingleton instance created!");
            value = 100;
        }
        
        public int getValue() {
            return value;
        }
        
        public void setValue(int value) {
            this.value = value;
        }
        
        public void doSomething() {
            System.out.println("EnumSingleton doing something with value: " + value);
        }
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("=== SINGLETON PATTERN DEMONSTRATIONS ===\n");
        
        // Scenario 1: Basic Singleton Usage
        System.out.println("=== Scenario 1: Basic Singleton Usage ===");
        SingletonMain s1 = SingletonMain.getInstance();
        SingletonMain s2 = SingletonMain.getInstance();
        s1.setValue(42);
        System.out.println("s1 value: " + s1.getValue());
        System.out.println("s2 value: " + s2.getValue());
        System.out.println("Same instance? " + (s1 == s2));
        
        // Scenario 2: Thread Safety Issues
        System.out.println("\n=== Scenario 2: Thread Safety Issues ===");
        testThreadSafety();
        
        // Scenario 3: Thread-Safe Singleton
        System.out.println("\n=== Scenario 3: Thread-Safe Singleton ===");
        testThreadSafeSingleton();
        
        // Scenario 4: Double-Checked Locking
        System.out.println("\n=== Scenario 4: Double-Checked Locking ===");
        testDoubleCheckedSingleton();
        
        // Scenario 5: Bill Pugh Singleton
        System.out.println("\n=== Scenario 5: Bill Pugh Singleton ===");
        testBillPughSingleton();
        
        // Scenario 6: Enum Singleton (Recommended)
        System.out.println("\n=== Scenario 6: Enum Singleton ===");
        testEnumSingleton();
        
        // Scenario 7: Serialization/Deserialization Issue
        System.out.println("\n=== Scenario 7: Serialization Test ===");
        testSerialization();
        
        // Scenario 8: Reflection Attack
        System.out.println("\n=== Scenario 8: Reflection Attack ===");
        testReflectionAttack();
        
        // Scenario 9: Clone Attack
        System.out.println("\n=== Scenario 9: Clone Attack ===");
        testCloneAttack();
        
        // Scenario 10: Real-World Example
        System.out.println("\n=== Scenario 10: Real-World Example ===");
        testRealWorldExample();
    }
    
    private static void testThreadSafety() throws InterruptedException {
        final int threadCount = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        Set<SingletonMain> instances = ConcurrentHashMap.newKeySet();
        
        // Reset instance for test
        instance = null;
        
        CountDownLatch latch = new CountDownLatch(threadCount);
        
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    latch.await(); // Start all threads at the same time
                    instances.add(SingletonMain.getInstance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            latch.countDown();
        }
        
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        
        System.out.println("Number of instances created: " + instances.size());
        System.out.println("Thread safety issue? " + (instances.size() > 1));
    }
    
    private static void testThreadSafeSingleton() throws InterruptedException {
        final int threadCount = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        Set<ThreadSafeSingleton> instances = ConcurrentHashMap.newKeySet();
        
        CountDownLatch latch = new CountDownLatch(threadCount);
        
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                    instances.add(ThreadSafeSingleton.getInstance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            latch.countDown();
        }
        
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        
        System.out.println("ThreadSafeSingleton instances created: " + instances.size());
    }
    
    private static void testDoubleCheckedSingleton() throws InterruptedException {
        final int threadCount = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        Set<DoubleCheckedSingleton> instances = ConcurrentHashMap.newKeySet();
        
        CountDownLatch latch = new CountDownLatch(threadCount);
        
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                    instances.add(DoubleCheckedSingleton.getInstance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            latch.countDown();
        }
        
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        
        System.out.println("DoubleCheckedSingleton instances created: " + instances.size());
    }
    
    private static void testBillPughSingleton() throws InterruptedException {
        final int threadCount = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        Set<BillPughSingleton> instances = ConcurrentHashMap.newKeySet();
        
        CountDownLatch latch = new CountDownLatch(threadCount);
        
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                    instances.add(BillPughSingleton.getInstance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            latch.countDown();
        }
        
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        
        System.out.println("BillPughSingleton instances created: " + instances.size());
    }
    
    private static void testEnumSingleton() throws InterruptedException {
        final int threadCount = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        Set<EnumSingleton> instances = ConcurrentHashMap.newKeySet();
        
        CountDownLatch latch = new CountDownLatch(threadCount);
        
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    latch.await();
                    instances.add(EnumSingleton.INSTANCE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            latch.countDown();
        }
        
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        
        System.out.println("EnumSingleton instances: " + instances.size());
        
        // Test enum singleton methods
        EnumSingleton.INSTANCE.setValue(999);
        EnumSingleton.INSTANCE.doSomething();
    }
    
    private static void testSerialization() throws IOException, ClassNotFoundException {
        System.out.println("\nTesting Serializable Singleton...");
        
        // Create a serializable singleton
        SerializableSingleton original = SerializableSingleton.getInstance();
        original.setValue(100);
        
        // Serialize
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(original);
        oos.close();
        
        // Deserialize
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        SerializableSingleton deserialized = (SerializableSingleton) ois.readObject();
        
        System.out.println("Original value: " + original.getValue());
        System.out.println("Deserialized value: " + deserialized.getValue());
        System.out.println("Same instance after deserialization? " + (original == deserialized));
    }
    
    private static void testReflectionAttack() {
        System.out.println("\nTesting Reflection Attack Protection...");
        
        try {
            // Try to break Bill Pugh singleton
            Constructor<BillPughSingleton> constructor = 
                BillPughSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            
            BillPughSingleton instance1 = BillPughSingleton.getInstance();
            BillPughSingleton instance2 = constructor.newInstance();
            
            System.out.println("BillPughSingleton broken by reflection? " + (instance1 != instance2));
        } catch (Exception e) {
            System.out.println("Reflection attack prevented: " + e.getMessage());
        }
        
        // Try to break Enum singleton (should be impossible)
        try {
            Constructor<EnumSingleton> constructor = 
                EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            EnumSingleton fake = constructor.newInstance("FAKE", 0);
            System.out.println("EnumSingleton broken by reflection? true");
        } catch (Exception e) {
            System.out.println("EnumSingleton reflection attack prevented: " + e.getMessage());
        }
    }
    
    private static void testCloneAttack() {
        System.out.println("\nTesting Clone Attack Protection...");
        
        // Cloneable singleton implementation
        CloneableSingleton original = CloneableSingleton.getInstance();
        
        try {
            CloneableSingleton cloned = (CloneableSingleton) original.clone();
            System.out.println("CloneableSingleton broken by cloning? " + (original != cloned));
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone attack prevented: " + e.getMessage());
        }
    }
    
    private static void testRealWorldExample() {
        System.out.println("\nReal-World Singleton Examples:");
        
        // Example 1: Configuration Manager
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();
        
        config1.setProperty("database.url", "jdbc:mysql://localhost:3306/mydb");
        config1.setProperty("server.port", "8080");
        
        System.out.println("Config1 database URL: " + config1.getProperty("database.url"));
        System.out.println("Config2 database URL: " + config2.getProperty("database.url"));
        System.out.println("Same config instance? " + (config1 == config2));
        
        // Example 2: Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        logger1.log("Application started");
        logger2.log("User logged in");
        
        System.out.println("Logger1 entries: " + logger1.getLogEntries().size());
        System.out.println("Logger2 entries: " + logger2.getLogEntries().size());
        System.out.println("Same logger instance? " + (logger1 == logger2));
        
        // Example 3: Database Connection Pool
        ConnectionPool pool1 = ConnectionPool.getInstance();
        ConnectionPool pool2 = ConnectionPool.getInstance();
        
        System.out.println("ConnectionPool instance 1 ID: " + pool1.getInstanceId());
        System.out.println("ConnectionPool instance 2 ID: " + pool2.getInstanceId());
        System.out.println("Same pool instance? " + (pool1 == pool2));
    }
    
    // ========== SERIALIZABLE SINGLETON ==========
    private static class SerializableSingleton implements Serializable {
        private static final long serialVersionUID = 1L;
        private static SerializableSingleton instance;
        private int value;
        
        private SerializableSingleton() {
            System.out.println("SerializableSingleton created!");
            value = 0;
        }
        
        public static synchronized SerializableSingleton getInstance() {
            if (instance == null) {
                instance = new SerializableSingleton();
            }
            return instance;
        }
        
        public int getValue() {
            return value;
        }
        
        public void setValue(int value) {
            this.value = value;
        }
        
        // This method prevents creating new instance during deserialization
        protected Object readResolve() {
            return getInstance();
        }
    }
    
    // ========== CLONEABLE SINGLETON ==========
    private static class CloneableSingleton implements Cloneable {
        private static CloneableSingleton instance;
        
        private CloneableSingleton() {
            System.out.println("CloneableSingleton created!");
        }
        
        public static synchronized CloneableSingleton getInstance() {
            if (instance == null) {
                instance = new CloneableSingleton();
            }
            return instance;
        }
        
        // Prevent cloning
        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException("Singleton cannot be cloned");
        }
    }
    
    // ========== REAL-WORLD SINGLETON IMPLEMENTATIONS ==========
    
    // Configuration Manager Singleton
    private static class ConfigurationManager {
        private static ConfigurationManager instance;
        private final Properties properties;
        
        private ConfigurationManager() {
            properties = new Properties();
            // Load default configuration
            properties.setProperty("app.name", "MyApplication");
            properties.setProperty("app.version", "1.0.0");
        }
        
        public static synchronized ConfigurationManager getInstance() {
            if (instance == null) {
                instance = new ConfigurationManager();
            }
            return instance;
        }
        
        public String getProperty(String key) {
            return properties.getProperty(key);
        }
        
        public void setProperty(String key, String value) {
            properties.setProperty(key, value);
        }
    }
    
    // Logger Singleton
    private static class Logger {
        private static volatile Logger instance;
        private final List<String> logEntries;
        
        private Logger() {
            logEntries = Collections.synchronizedList(new ArrayList<>());
        }
        
        public static Logger getInstance() {
            if (instance == null) {
                synchronized (Logger.class) {
                    if (instance == null) {
                        instance = new Logger();
                    }
                }
            }
            return instance;
        }
        
        public void log(String message) {
            String timestamp = new java.util.Date().toString();
            logEntries.add(timestamp + " - " + message);
        }
        
        public List<String> getLogEntries() {
            return new ArrayList<>(logEntries);
        }
    }
    
    // Connection Pool Singleton
    private static class ConnectionPool {
        private static final ConnectionPool INSTANCE = new ConnectionPool();
        private final String instanceId;
        
        private ConnectionPool() {
            instanceId = UUID.randomUUID().toString();
            System.out.println("ConnectionPool initialized with ID: " + instanceId);
            // Initialize connection pool here
        }
        
        public static ConnectionPool getInstance() {
            return INSTANCE;
        }
        
        public String getInstanceId() {
            return instanceId;
        }
    }
}