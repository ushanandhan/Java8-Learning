package com.basics;

class ThreadExample implements Runnable{
    long sum;
     @Override
    public void run() {
        synchronized (this){
            for (int i =0;i<10000;i++){
                sum+=i;
            }
            notify();
            System.out.println(Thread.currentThread().getName());
        }
    }
}

public class ThreadDemo{
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        ThreadExample threadExample = new ThreadExample();
        Thread thread = new Thread(threadExample);
        thread.start();
//        synchronized (thread){
//            thread.wait();
//        }
        System.out.println(threadExample.sum);
    }
}

