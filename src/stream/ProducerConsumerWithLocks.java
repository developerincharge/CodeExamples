package stream;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithLocks {
    private static final int BUFFER_CAPACITY = 5;
    private static final int TOTAL_ITEMS = 20;
    
    private final Queue<Integer> buffer = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    
    private AtomicInteger itemCounter = new AtomicInteger(0);
    private volatile boolean productionFinished = false;

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerWithLocks pc = new ProducerConsumerWithLocks();
        pc.start();
    }
    
    public void start() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        // Start producers and consumers
        executor.submit(new Producer("Producer-1"));
        executor.submit(new Producer("Producer-2"));
        executor.submit(new Consumer("Consumer-1"));
        executor.submit(new Consumer("Consumer-2"));
        
        // Run for some time
        Thread.sleep(10000);
        
        // Stop production
        productionFinished = true;
        
        // Wake up all waiting threads
        lock.lock();
        try {
            notEmpty.signalAll();
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
        
        executor.shutdown();
        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
        
        System.out.println("Final buffer size: " + buffer.size());
    }
    
    class Producer implements Runnable {
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
                    
                    produce(item);
                }
                System.out.println(name + " finished production.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        private void produce(int item) throws InterruptedException {
            lock.lock();
            try {
                // Wait while buffer is full
                while (buffer.size() == BUFFER_CAPACITY) {
                    System.out.println(name + " waiting - buffer full");
                    notFull.await();
                }
                
                buffer.offer(item);
                System.out.println(name + " produced: " + item + " | Buffer size: " + buffer.size());
                
                // Signal consumers that buffer is not empty
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
            
            // Simulate production time
            Thread.sleep(ThreadLocalRandom.current().nextInt(100, 400));
        }
    }
    
    class Consumer implements Runnable {
        private final String name;
        
        public Consumer(String name) {
            this.name = name;
        }
        
        @Override
        public void run() {
            try {
                while (!(productionFinished && buffer.isEmpty())) {
                    Integer item = consume();
                    if (item != null) {
                        process(item);
                    }
                }
                System.out.println(name + " finished consumption.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        private Integer consume() throws InterruptedException {
            lock.lock();
            try {
                // Wait while buffer is empty (but only if production might continue)
                while (buffer.isEmpty()) {
                    if (productionFinished) {
                        return null; // No more items coming
                    }
                    System.out.println(name + " waiting - buffer empty");
                    notEmpty.await(1, TimeUnit.SECONDS); // Wait with timeout
                    if (buffer.isEmpty() && productionFinished) {
                        return null;
                    }
                }
                
                Integer item = buffer.poll();
                System.out.println(name + " consumed: " + item + " | Buffer size: " + buffer.size());
                
                // Signal producers that buffer is not full
                notFull.signal();
                return item;
            } finally {
                lock.unlock();
            }
        }
        
        private void process(int item) throws InterruptedException {
            // Simulate processing time
            Thread.sleep(ThreadLocalRandom.current().nextInt(200, 600));
        }
    }
}