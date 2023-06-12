package com.concurency;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

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
            System.out.println("I'll run in a  separate thread than main thread : "+Thread.currentThread().getName());
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
                    System.out.println("processed in : "+Thread.currentThread().getName());
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
        CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> "Hello "+name);

        System.out.println(greetingFuture.get());
    }

    @Test
    public void joiningMultipleThreads() throws ExecutionException, InterruptedException {
        List<CompletableFuture<String>> completableFutures = new ArrayList<>();

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Ushan";
        });
        completableFutures.add(future1);

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Ariya";
        });
        completableFutures.add(future2);

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Varadhan";
        });

        String join = future3.get();
        String collect = completableFutures.stream().map(CompletableFuture::join).collect(Collectors.joining("-"));
        System.out.println("Collectivly future result : "+collect);
        System.out.println("Single Completable future result : "+join);
    }
}
