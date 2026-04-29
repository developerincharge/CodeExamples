package singleton;

public class ThreadSafeSingleton {

    // volatile ensures visibility across threads
    private static volatile ThreadSafeSingleton instance = null;
    //private String config;

    private ThreadSafeSingleton() {
        //this.config = "App Configuration Loaded!";
        System.out.println("✅ Thread-Safe Singleton Created!");
    }

    // Double-checked locking for best performance
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {                         // First check (no lock)
            synchronized (ThreadSafeSingleton.class) {  // Lock the class
                if (instance == null) {                 // Second check (with lock)
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

//    public String getConfig() {
//        return config;
//    }

    public static void main(String[] args) throws InterruptedException {

        // Simulate multiple threads trying to create instance
        Runnable task = () -> {
            ThreadSafeSingleton s = ThreadSafeSingleton.getInstance();
            System.out.println(Thread.currentThread().getName()
                    + " got instance: " + s.hashCode());
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}