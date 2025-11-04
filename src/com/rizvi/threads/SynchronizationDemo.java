package com.rizvi.threads;

class A1{
    synchronized void m1(){
        for(int i = 0; i <= 15;i++){
            System.out.println("Current Thread is : "+Thread.currentThread().getName()+" ---> "+i);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
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
        A1 a2 = new A1();
        ThreadA1 t1 = new ThreadA1(a1);
        ThreadA2 t2 = new ThreadA2(a2);
        t1.setName("T-1");
        t2.setName("T-2");
        t1.start();
        t2.start();

    }
}
