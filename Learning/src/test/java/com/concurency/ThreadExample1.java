package com.concurency;

/**
 * This is to verify how sleep method of thread is working.
 */
public class ThreadExample1 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Task());
//        Thread.sleep(1000);
        thread.start();
        System.out.println("Thread Name: "+Thread.currentThread().getName());
    }
}

class Task implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread Name: "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
