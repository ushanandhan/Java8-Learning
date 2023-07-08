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

    public static int compute(int a){
        return a*10;
    }

    @Test
    public void TwoIndependentCompletableFutureUsingCombineTest(){
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> compute(1));
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> compute(2));

        future1.thenCombine(future2, Integer::sum).thenAccept(System.out::println);
}

    @Test
    public void TwoDependentCompletableFutureUsingComposeTest() {
//        Using thenApply we would get only wrapped Completable Future result.
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> compute(1));
        CompletableFuture<CompletableFuture<Integer>> completableFutureUsingApply = future1.thenApply(a -> CompletableFuture.supplyAsync(() -> compute(a + 2)));
        completableFutureUsingApply.thenAccept(System.out::println);
//        Using thenCompose we would get exact value from Future result.
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> compute(2));
        CompletableFuture<Integer> completableFutureUsingCompose = future2.thenCompose(a -> CompletableFuture.supplyAsync(() -> compute(a + 2)));
        completableFutureUsingCompose.thenAccept(System.out::println);
    }

    @Test
    public void WithExceptionally(){

    }

}
