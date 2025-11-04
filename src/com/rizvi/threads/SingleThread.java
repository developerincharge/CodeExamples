package com.rizvi.threads;

public class SingleThread {

    public static void main(String[] args) {

        System.out.println(" A Single Thread  is Running " );

        Thread th = Thread.currentThread();
        System.out.println("Name of thread : "+th);

        String tName = th.getName();
        System.out.println("Name of Thread group  : "+tName);

        System.out.println("Priority of Thread:  "+th.getPriority());

        System.out.println(Thread.currentThread().getName() +
                " Under the Thread Group of " +
                Thread.currentThread().getThreadGroup().getName() +
                " with the priority of " +th.getPriority());


        Thread th1 = new Thread();
        System.out.println(th1);
        th1.setPriority(10);
        System.out.println(th1);

        System.out.println("#######################\n");

        System.out.println(Thread.MIN_PRIORITY);
        System.out.println(Thread.NORM_PRIORITY);
        System.out.println(Thread.MAX_PRIORITY);



    }
}
