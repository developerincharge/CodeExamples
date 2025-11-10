package com.rizvi.threads;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count = 0;


//    public void increment() {
//        count++; // Not thread-safe!
//    }
//
//    public int getCount() {
//        return count;
//    }


//    public synchronized void increment() {
//        count++; // Thread-safe
//    }
//
//    public synchronized int getCount() {
//        return count;
//    }

      // Synchronized method on Block

//        public void increment() {
//        synchronized (this) {
//            count++;
//        }
//    }

    // Explicit Lock with ReentrantLock
    //More advanced control than synchronized.

    private ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }

}
