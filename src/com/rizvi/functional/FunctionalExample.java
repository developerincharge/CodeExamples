package com.rizvi.functional;

public class FunctionalExample {

    public static void main(String[] args) throws InterruptedException {

//        Runnable runnable = new Runnable() {
//
//            @Override
//            public void run() {
//
//            }
//        };
//
//        Runnable run = () -> System.out.println("run method");
//        new Thread(runnable).start();
//        Thread.sleep(2000);
//        System.out.println("Hello Thread");

//        MyFunction test = (i) -> System.out.println("25");
//        Thread th = new Thread();
//        test.test(15);
//        th.start();
//        Thread.sleep(3000);
//        System.out.println("Hello Again");


//        MyFunction myFunction = i -> i*10;
//        System.out.println(myFunction.test(15));

      FunctionalInterfaceMultipleArgs funcArgs =  (s1,s2) -> s1 + " : "+s2;
        System.out.println(funcArgs.test("Syed","Rizvi"));

        }
}
