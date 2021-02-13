package com.concurency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    @Test
    public void example1(){
        Semaphore sem = new Semaphore(1);
        new IncThread(sem,"A");
        new DecThread(sem,"B");
    }

}
class Shared{
    static int count = 0;
}

class IncThread implements Runnable{

    String name;
    Semaphore sem;

    IncThread(Semaphore s,String n){
        sem = s;
        name = n;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            System.out.println(name+" is waiting for permit.");
            sem.acquire();
            System.out.println(name+" gets a permit.");
            for (int i =0;i<5;i++){
                Shared.count++;
                System.out.println(name+" : "+Shared.count);
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+" : releases the permit");
        sem.release();
    }
}

class DecThread implements Runnable{

    String name;
    Semaphore sem;

    DecThread(Semaphore s,String n){
        sem = s;
        name = n;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            System.out.println(name+" is waiting for permit.");
            sem.acquire();
            System.out.println(name+" gets a permit.");
            for (int i =0;i<5;i++){
                Shared.count--;
                System.out.println(name+" : "+Shared.count);
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+" : releases the permit");
        sem.release();
    }
}