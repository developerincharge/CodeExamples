package com.rizvi.threads;

class A1{
    void m1(){
        try{

            synchronized(this){
                for(int i = 1; i <= 10; i++){
                    System.out.println(Thread.currentThread().getName()+" is processing synchronized-block:- "+i);
                    Thread.sleep(500);
                }
            }
            for(int i = 1; i <= 10; i++){
                System.out.println(Thread.currentThread().getName()+" is processing non-synchronized-block:- "+i);
                Thread.sleep(500);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
class ThreadA1 extends Thread{
    A1 a1;

    ThreadA1(A1 a1){
        this.a1 = a1;
    }

    public void run(){
        a1.m1();
    }
}
class ThreadA2 extends Thread{
    A1 a1;

    ThreadA2(A1 a1){
        this.a1 = a1;
    }

    public void run(){
        a1.m1();
    }
}
public class SynchronizationDemo{
    public static void main(String args[]){
        A1 a1 = new A1();
        ThreadA1 t1 = new ThreadA1(a1);
        ThreadA2 t2 = new ThreadA2(a1);
       // A1 a2 = new A1();
        // ThreadA2 t2 = new ThreadA2(a2);

        t1.setName("T-1");
        t2.setName("T-2");
        t1.start();
        t2.start();

    }
}
