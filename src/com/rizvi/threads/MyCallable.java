package com.rizvi.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyCallable implements Callable<Integer> {
    
    // Instance variable - each Callable instance has its own
    int result = 1;
    
    @Override
    public Integer call() throws Exception {
        // perform computation
        System.out.println(Thread.currentThread().getName() + " is executing call() method");
        
        // Simulate some computation
        Thread.sleep(2000); // 2 seconds delay
        
        // Perform some calculation
        result = result * 10;
        
        return result;
    }
    
    // ========== SCENARIO 1: BASIC USAGE ==========
    public static void scenario1() throws Exception {
        System.out.println("\n=== SCENARIO 1: Basic Callable Usage ===");
        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new MyCallable());
        
        System.out.println("Main thread continues while Callable is executing...");
        
        // Do some other work
        Thread.sleep(1000);
        System.out.println("Main thread doing other tasks...");
        
        // Get the result - this will block until Callable completes
        Integer result = future.get();
        System.out.println("Result is: " + result);
        
        executor.shutdown();
    }
    
    // ========== SCENARIO 2: MULTIPLE CALLABLES ==========
    public static void scenario2() throws Exception {
        System.out.println("\n=== SCENARIO 2: Multiple Callables with ExecutorService ===");
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = new ArrayList<>();
        
        // Submit 5 tasks
        for (int i = 1; i <= 5; i++) {
            MyCallable task = new MyCallable();
            task.result = i; // Set different initial value for each task
            Future<Integer> future = executor.submit(task);
            futures.add(future);
        }
        
        System.out.println("All tasks submitted. Getting results...");
        
        // Collect results
        for (int i = 0; i < futures.size(); i++) {
            Integer result = futures.get(i).get();
            System.out.println("Task " + (i + 1) + " result: " + result);
        }
        
        executor.shutdown();
    }
    
    // ========== SCENARIO 3: CALLABLE WITH EXCEPTION ==========
    static class MyCallableWithException implements Callable<Integer> {
        private boolean throwException;
        
        public MyCallableWithException(boolean throwException) {
            this.throwException = throwException;
        }
        
        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName() + " started");
            
            if (throwException) {
                throw new RuntimeException("Simulated exception from Callable!");
            }
            
            Thread.sleep(1000);
            return 42;
        }
    }
    
    public static void scenario3() {
        System.out.println("\n=== SCENARIO 3: Handling Exceptions in Callable ===");
        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        // Submit a task that throws exception
        Future<Integer> future = executor.submit(new MyCallableWithException(true));
        
        try {
            Integer result = future.get();
            System.out.println("Result: " + result);
        } catch (ExecutionException e) {
            System.out.println("Exception caught: " + e.getCause().getMessage());
        } catch (InterruptedException e) {
            System.out.println("Task interrupted: " + e.getMessage());
        }
        
        executor.shutdown();
    }
    
    // ========== SCENARIO 4: CALLABLE WITH PARAMETERS ==========
    static class ParamCallable implements Callable<Integer> {
        private int multiplier;
        private int delayMs;
        
        public ParamCallable(int multiplier, int delayMs) {
            this.multiplier = multiplier;
            this.delayMs = delayMs;
        }
        
        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName() + 
                              " processing with multiplier: " + multiplier);
            Thread.sleep(delayMs);
            return 10 * multiplier;
        }
    }
    
    public static void scenario4() throws Exception {
        System.out.println("\n=== SCENARIO 4: Callable with Parameters ===");
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        // Submit tasks with different parameters
        Future<Integer> task1 = executor.submit(new ParamCallable(5, 1000));
        Future<Integer> task2 = executor.submit(new ParamCallable(8, 2000));
        Future<Integer> task3 = executor.submit(new ParamCallable(3, 500));
        
        // Get results as they complete
        System.out.println("Task 3 result (shortest delay): " + task3.get());
        System.out.println("Task 1 result: " + task1.get());
        System.out.println("Task 2 result (longest delay): " + task2.get());
        
        executor.shutdown();
    }
    
    // ========== SCENARIO 5: FUTURE METHODS DEMO ==========
    public static void scenario5() throws Exception {
        System.out.println("\n=== SCENARIO 5: Future Methods Demonstration ===");
        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        MyCallable task = new MyCallable();
        Future<Integer> future = executor.submit(task);
        
        // Check if task is done
        System.out.println("Task completed? " + future.isDone());
        
        // Cancel the task (if not started)
//         boolean cancelled = future.cancel(true);
//         System.out.println("Task cancelled? " + cancelled);
        
        // Wait with timeout
        try {
            Integer result = future.get(1, TimeUnit.SECONDS); // Wait only 1 second
            System.out.println("Result: " + result);
        } catch (TimeoutException e) {
            System.out.println("Task took too long! " + e.getMessage());
        }
        
        // Now wait without timeout
        if (!future.isDone()) {
            System.out.println("Waiting for task to complete...");
            Integer result = future.get(); // Wait indefinitely
            System.out.println("Final result: " + result);
        }
        
        System.out.println("Task completed now? " + future.isDone());
        System.out.println("Task cancelled? " + future.isCancelled());
        
        executor.shutdown();
    }
    
    // ========== SCENARIO 6: CALLABLE VS RUNNABLE ==========
    public static void scenario6() throws Exception {
        System.out.println("\n=== SCENARIO 6: Callable vs Runnable Comparison ===");
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        // Runnable - doesn't return result, doesn't throw checked exceptions
        Runnable runnableTask = () -> {
            try {
                Thread.sleep(1000);
                System.out.println("Runnable task completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        
        // Callable - returns result, can throw exceptions
        Callable<Integer> callableTask = () -> {
            Thread.sleep(1000);
            System.out.println("Callable task completed");
            return 100;
        };
        
        // Execute Runnable - returns null Future
        Future<?> runnableFuture = executor.submit(runnableTask);
        
        // Execute Callable - returns Future with result
        Future<Integer> callableFuture = executor.submit(callableTask);
        
        // Wait for both to complete
        runnableFuture.get(); // Returns null
        Integer result = callableFuture.get();
        
        System.out.println("Callable returned: " + result);
        
        executor.shutdown();
    }
    
    // ========== SCENARIO 7: COMPLEX COMPUTATION ==========
    static class FactorialCallable implements Callable<Long> {
        private int number;
        
        public FactorialCallable(int number) {
            this.number = number;
        }
        
        @Override
        public Long call() throws Exception {
            System.out.println(Thread.currentThread().getName() + 
                              " calculating factorial of " + number);
            
            if (number < 0) {
                throw new IllegalArgumentException("Number must be non-negative");
            }
            
            long result = 1;
            for (int i = 2; i <= number; i++) {
                result *= i;
                Thread.sleep(50); // Simulate computation time
            }
            
            return result;
        }
    }
    
    public static void scenario7() throws Exception {
        System.out.println("\n=== SCENARIO 7: Complex Computation - Factorial ===");
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Calculate factorials of different numbers
        int[] numbers = {5, 10, 15};
        List<Future<Long>> futures = new ArrayList<>();
        
        long startTime = System.currentTimeMillis();
        
        for (int num : numbers) {
            futures.add(executor.submit(new FactorialCallable(num)));
        }
        
        // Get results
        for (int i = 0; i < numbers.length; i++) {
            Long result = futures.get(i).get();
            System.out.println("Factorial of " + numbers[i] + " = " + result);
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("Total time: " + (endTime - startTime) + "ms");
        
        executor.shutdown();
    }
    
    // ========== SCENARIO 8: INVOKE ALL DEMO ==========
    public static void scenario8() throws Exception {
        System.out.println("\n=== SCENARIO 8: invokeAll() Method ===");
        
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        List<Callable<Integer>> tasks = new ArrayList<>();
        
        // Create multiple tasks
        for (int i = 1; i <= 4; i++) {
            final int taskId = i;
            tasks.add(() -> {
                System.out.println("Task " + taskId + " started");
                Thread.sleep(taskId * 500); // Different delays
                return taskId * 100;
            });
        }
        
        // Execute all tasks and wait for all to complete
        System.out.println("Submitting all tasks with invokeAll()...");
        List<Future<Integer>> futures = executor.invokeAll(tasks);
        
        System.out.println("All tasks completed. Getting results:");
        for (int i = 0; i < futures.size(); i++) {
            System.out.println("Task " + (i + 1) + " result: " + futures.get(i).get());
        }
        
        executor.shutdown();
    }
    
    // ========== SCENARIO 9: INVOKE ANY DEMO ==========
    public static void scenario9() throws Exception {
        System.out.println("\n=== SCENARIO 9: invokeAny() Method ===");
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        List<Callable<Integer>> tasks = new ArrayList<>();
        
        // Create tasks with different completion times
        tasks.add(() -> {
            Thread.sleep(3000);
            return 300;
        });
        
        tasks.add(() -> {
            Thread.sleep(1000);
            return 100;
        });
        
        tasks.add(() -> {
            Thread.sleep(2000);
            return 200;
        });
        
        // Execute and get first completed task result
        System.out.println("Getting first completed task result...");
        Integer firstResult = executor.invokeAny(tasks);
        System.out.println("First completed task returned: " + firstResult);
        
        executor.shutdown();
    }
    
    // ========== MAIN METHOD ==========
    public static void main(String[] args) throws Exception {
        System.out.println("=== CALLABLE INTERFACE COMPLETE DEMONSTRATION ===\n");
        
        // Run all scenarios
        scenario1();  // Basic usage
        scenario2();  // Multiple Callables
        scenario3();  // Exception handling
        scenario4();  // With parameters
        scenario5();  // Future methods
        scenario6();  // Callable vs Runnable
        scenario7();  // Complex computation
        scenario8();  // invokeAll()
        scenario9();  // invokeAny()
        
        System.out.println("\n=== ALL DEMONSTRATIONS COMPLETED ===");
    }
}