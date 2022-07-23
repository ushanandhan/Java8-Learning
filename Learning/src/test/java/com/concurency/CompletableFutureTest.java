package com.concurency;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureTest {

    @Test
    public void runAsyncTest() throws ExecutionException, InterruptedException {
        System.out.println("Main Thread is : "+Thread.currentThread().getName());
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I'll run in a  separate thread then main thread : "+Thread.currentThread().getName());
        });
        future.get();
        System.out.println("processed in : "+Thread.currentThread().getName());
    }

    @Test
    public void supplyAsync() throws ExecutionException, InterruptedException {
        Executor executor = Executors.newFixedThreadPool(10);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                for (int i = 0;i<10;i++){
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result of the async computation";
        },executor);
        System.out.println("Printing this because it is async");
        System.out.println(future.get());
        System.out.println("Processing");
    }

    @Test
    public void thenApply() throws ExecutionException, InterruptedException {
//        Create a Completable future
        CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Ushan";
        });
//        Attach a callback to the Future using thenApply()
        CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> {
            return "Hello "+name;
        });

        System.out.println(greetingFuture.get());
    }

    @Test
    public void joiningMultipleThreads(){
        List<Integer> integers = Stream.iterate(1, integer -> integer+1)
                .limit(100)
                .collect(Collectors.toList());
        System.out.println(integers);


    }
}
