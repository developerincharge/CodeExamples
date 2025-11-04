package stream;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerWithSemaphores {
    private static final int BUFFER_CAPACITY = 5;
    private static final int TOTAL_ITEMS = 20;
    
    private final Queue<Integer> buffer = new LinkedList<>();
    private final Semaphore emptySlots = new Semaphore(BUFFER_CAPACITY);
    private final Semaphore fullSlots = new Semaphore(0);
    private final Object lock = new Object(); // For buffer access synchronization
    
    private AtomicInteger itemCounter = new AtomicInteger(0);
    private volatile boolean productionFinished = false;

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerWithSemaphores pc = new ProducerConsumerWithSemaphores();
        pc.start();
    }
    
    public void start() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        executor.submit(new Producer("Producer-1"));
        executor.submit(new Producer("Producer-2"));
        executor.submit(new Consumer("Consumer-1"));
        executor.submit(new Consumer("Consumer-2"));
        
        Thread.sleep(8000);
        productionFinished = true;
        
        // Release any waiting threads
        emptySlots.release(BUFFER_CAPACITY);
        fullSlots.release(BUFFER_CAPACITY);
        
        executor.shutdown();
        executor.awaitTermination(3, TimeUnit.SECONDS);
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
                        itemCounter.decrementAndGet();
                        break;
                    }
                    
                    // Acquire empty slot permit
                    if (emptySlots.tryAcquire(1, 100, TimeUnit.MILLISECONDS)) {
                        synchronized (lock) {
                            buffer.offer(item);
                            System.out.println(name + " produced: " + item + " | Buffer size: " + buffer.size());
                        }
                        // Release full slot permit
                        fullSlots.release();
                    }
                    
                    Thread.sleep(ThreadLocalRandom.current().nextInt(50, 300));
                }
                System.out.println(name + " finished.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
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
                    // Acquire full slot permit
                    if (fullSlots.tryAcquire(1, 100, TimeUnit.MILLISECONDS)) {
                        Integer item;
                        synchronized (lock) {
                            item = buffer.poll();
                        }
                        if (item != null) {
                            System.out.println(name + " consumed: " + item + " | Buffer size: " + buffer.size());
                            // Release empty slot permit
                            emptySlots.release();
                            process(item);
                        }
                    }
                }
                System.out.println(name + " finished.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        private void process(int item) throws InterruptedException {
            Thread.sleep(ThreadLocalRandom.current().nextInt(100, 500));
        }
    }
}