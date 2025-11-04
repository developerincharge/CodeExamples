package stream;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerExample {
    private static final int BUFFER_CAPACITY = 5;
    private static final int PRODUCER_COUNT = 3;
    private static final int CONSUMER_COUNT = 2;
    private static final int TOTAL_ITEMS = 20;
    
    private static BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(BUFFER_CAPACITY);
    private static AtomicInteger itemCounter = new AtomicInteger(0);
    private static volatile boolean productionFinished = false;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(PRODUCER_COUNT + CONSUMER_COUNT);
        
        // Start producers
        for (int i = 0; i < PRODUCER_COUNT; i++) {
            executor.submit(new Producer("Producer-" + i));
        }
        
        // Start consumers
        for (int i = 0; i < CONSUMER_COUNT; i++) {
            executor.submit(new Consumer("Consumer-" + i));
        }
        
        // Let the system run for a while
        Thread.sleep(5000);
        
        // Signal producers to stop
        productionFinished = true;
        
        // Shutdown gracefully
        executor.shutdown();
        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
        
        System.out.println("All tasks completed!");
    }
    
    static class Producer implements Runnable {
        private final String name;
        
        public Producer(String name) {
            this.name = name;
        }
        
        @Override
        public void run() {
            try {
                while (!productionFinished && itemCounter.get() < TOTAL_ITEMS) {
                    int item = itemCounter.incrementAndGet();
                    if (item > TOTAL_ITEMS) {
                        break;
                    }
                    
                    // put() blocks if buffer is full
                    buffer.put(item);
                    System.out.println(name + " produced: " + item + " | Buffer size: " + buffer.size());
                    
                    // Simulate production time
                    Thread.sleep(ThreadLocalRandom.current().nextInt(100, 500));
                }
                System.out.println(name + " finished production.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(name + " was interrupted.");
            }
        }
    }
    
    static class Consumer implements Runnable {
        private final String name;
        
        public Consumer(String name) {
            this.name = name;
        }
        
        @Override
        public void run() {
            try {
                while (!(productionFinished && buffer.isEmpty())) {
                    // take() blocks if buffer is empty
                    Integer item = buffer.poll(2, TimeUnit.SECONDS); // Wait max 2 seconds
                    
                    if (item != null) {
                        processItem(item);
                    } else if (productionFinished) {
                        break; // No more items coming
                    }
                }
                System.out.println(name + " finished consumption.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(name + " was interrupted.");
            }
        }
        
        private void processItem(int item) throws InterruptedException {
            System.out.println(name + " consumed: " + item + " | Buffer size: " + buffer.size());
            // Simulate processing time
            Thread.sleep(ThreadLocalRandom.current().nextInt(200, 800));
        }
    }
}