package singleton;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern with Thread Safety Demo ===\n");

        // Test 1: Basic Singleton functionality
        System.out.println("Test 1: Basic Singleton Instance Access");
        testBasicSingleton();

        // Test 2: Thread safety test
        System.out.println("\nTest 2: Thread Safety Test");
        testThreadSafety();

        // Test 3: Data consistency test
        System.out.println("\nTest 3: Data Consistency Test");
        testDataConsistency();

        // Test 4: Performance test with multiple threads
        System.out.println("\nTest 4: Performance Test with Multiple Threads");
        testPerformanceWithMultipleThreads();

        System.out.println("\n=== All tests completed ===");
    }

    static void testBasicSingleton() {
        // Get singleton instance multiple times
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println("Instance 1 Hash: " + instance1.hashCode());
        System.out.println("Instance 2 Hash: " + instance2.hashCode());
        System.out.println("Are both references the same? " + (instance1 == instance2));

        // Display countries
        instance1.displayCountries();
    }

    static void testThreadSafety() {
        final int threadCount = 5;
        final Singleton[] instances = new Singleton[threadCount];
        final CountDownLatch latch = new CountDownLatch(threadCount);

        // Create multiple threads that access the singleton simultaneously
        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            new Thread(() -> {
                instances[index] = Singleton.getInstance();
                System.out.println("Thread " + index + " got instance with hash: " + instances[index].hashCode());
                latch.countDown();
            }).start();
        }

        // Wait for all threads to complete
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Verify all instances are the same
        boolean allSame = true;
        for (int i = 1; i < threadCount; i++) {
            if (instances[0] != instances[i]) {
                allSame = false;
                break;
            }
        }

        System.out.println("All threads got the same instance? " + allSame);
    }

    static void testDataConsistency() {
        Singleton singleton = Singleton.getInstance();

        // Get countries multiple times
        List<Country> countries1 = singleton.getCountries();
        List<Country> countries2 = singleton.getCountries();

        System.out.println("First call countries count: " + countries1.size());
        System.out.println("Second call countries count: " + countries2.size());
        System.out.println("Are both country lists equal? " + countries1.equals(countries2));

        // Test country search
        Country us = singleton.findCountryByCode("US");
        Country jp = singleton.findCountryByCode("JP");

        System.out.println("Found US: " + (us != null ? us.getName() : "Not Found"));
        System.out.println("Found JP: " + (jp != null ? jp.getName() : "Not Found"));
        System.out.println("Invalid code: " + (singleton.findCountryByCode("XX") != null ?
                singleton.findCountryByCode("XX").getName() : "Not Found"));
    }

    static void testPerformanceWithMultipleThreads() {
        final int taskCount = 10;
        final ExecutorService executor = Executors.newFixedThreadPool(taskCount);
        final CountDownLatch latch = new CountDownLatch(taskCount);
        long startTime = System.currentTimeMillis();

        // Multiple threads accessing getCountries simultaneously
        for (int i = 0; i < taskCount; i++) {
            final int taskId = i;
            executor.submit(() -> {
                Singleton singleton = Singleton.getInstance();
                List<Country> countries = singleton.getCountries();
                System.out.println("Task " + taskId + " retrieved " + countries.size() + " countries");
                latch.countDown();
            });
        }

        // Wait for all tasks to complete
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        executor.shutdown();
        long endTime = System.currentTimeMillis();

        System.out.println("All " + taskCount + " tasks completed in " + (endTime - startTime) + " ms");
    }
}
