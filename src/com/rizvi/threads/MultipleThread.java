package com.rizvi.threads;

class HaiThread extends Thread{
    public HaiThread(){
       super();
       start();
    }

    public void run(){

        System.out.println("Run Method in HaiThread in Thread-0\n");
        for(int i =0; i <= 10; i++){
            System.out.println(Thread.currentThread().getName() +
                    " Under the Thread Group of " +
                    Thread.currentThread().getThreadGroup().getName() +
                    " with the priority of " + Thread.currentThread().getPriority());

            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.getMessage();
            }
        }
    }
}

class HelloThread implements Runnable{

    public HelloThread(){
        Thread t1 = new Thread(this);
        t1.start();
    }

    public void run() {
        System.out.println("Run Method in HelloThread in Thread-1\n");
        for(int i =0; i <= 10; i++){
            System.out.println(Thread.currentThread().getName() +
                    " Under the Thread Group of " +
                    Thread.currentThread().getThreadGroup().getName() +
                    " with the priority of " + Thread.currentThread().getPriority());

            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.getMessage();
            }
        }

    }
}


public class MultipleThread {

    public static void main(String[] args) {



//        Thread thread1 = new Thread("Thread 1");
//        Thread thread2 = new Thread("Thread 2");
//
//        // start the  thread
//        thread1.start();
//        thread2.start();
//
//        System.out.println(thread1.getName());
//        System.out.println("##############");
//        System.out.println(thread2.getName());

        HaiThread ht1 = new HaiThread();
        HelloThread th2 = new HelloThread();

    }

}
