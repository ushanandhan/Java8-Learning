package com.concurency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecuterServiceTest {

    @Test
    public void FixedThreadPool() {
//        Create the Thread pool
        ExecutorService service = Executors.newFixedThreadPool(10);
//        submit the tasks for execution
        for(int i =0;i<100;i++){
            service.execute(() -> System.out.println("Thread Name: "+ Thread.currentThread().getName()));
        }
        System.out.println("Thread Name: "+ Thread.currentThread().getName());
    }

    @Test
    public void ThreadPoolPick() {
//        Create the Thread pool
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
//        submit the tasks for execution
        for(int i =0;i<100;i++){
            service.execute(() -> System.out.println("Thread Name: "+ Thread.currentThread().getName()));
        }
        System.out.println("Thread Name: "+ Thread.currentThread().getName());
    }

    @Test
    public void cacheThreadPool() {
//        Create the Thread pool
        ExecutorService service = Executors.newCachedThreadPool();
//        submit the tasks for execution
        for(int i =0;i<100;i++){
            service.execute(() -> System.out.println("Thread Name: "+ Thread.currentThread().getName()));
        }
        System.out.println("Thread Name: "+ Thread.currentThread().getName());
    }

    @Test
    public void scheduledThreadPool(){
//        for scheduling of task
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

//        task to run after 10 seconds delay
        service.schedule(() -> System.out.println("Task 1 running"),10, TimeUnit.SECONDS);

//        task to run repeatedly every 10 seconds after 15 seconds initial delay
        service.scheduleAtFixedRate(() -> System.out.println("Task 2 running"),15,10,TimeUnit.SECONDS);

//        task to run repeatedly 10 seconds after previous task completes
        service.scheduleWithFixedDelay(() -> System.out.println("Task 3 running"),15,10,TimeUnit.SECONDS);

        System.out.println("Thread Name: "+ Thread.currentThread().getName());
    }
}
