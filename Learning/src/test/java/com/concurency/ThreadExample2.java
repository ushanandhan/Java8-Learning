package com.concurency;

/**
 * This is to check how thread priority works
 */
public class ThreadExample2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> System.out.println("Thread is : "+Thread.currentThread().getName()));
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread is : "+Thread.currentThread().getName());
        });
//        for (int i =0;i<5;i++){
            thread1.setPriority(3);
            thread2.setPriority(10);
            thread1.start();
            thread2.start();
//        }
    }
}
