package com.concurency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

public class ProducerConsumerUsingSemaphore {

    @Test
    public void producerConsumerTest(){
        Q q = new Q();
        new Consumer(q);
        new Producer(q);
    }
}
class Q{
    int n;

    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get(){
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Got : "+n);
    }

    void put(int n){
        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.n = n;
        System.out.println("Put : "+n);
        semCon.release();
    }
}
class Producer implements Runnable{

    Q q;

    Producer(Q q){
        this.q = q;
        new Thread(this,"Producer").start();
    }
    @Override
    public void run() {
        for (int i = 0;i<5;i++) q.put(i);
    }
}

class Consumer implements Runnable{
    Q q;

    Consumer(Q q){
        this.q = q;
        new Thread(this,"Consumer").start();
    }

    @Override
    public void run() {
        for (int i =0;i<5;i++) q.get();
    }
}
