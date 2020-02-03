package com.github.senin24.bzdu.completablefeature;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.springframework.util.Assert;

public class TestCompletableFutureApp implements Runnable{

  private static ExecutorService executor = Executors.newFixedThreadPool(5, new ThreadFactory() {
    private int count = 1;
    @Override
    public Thread newThread(Runnable runnable) {
      return new Thread(runnable, "my-custom-executor-" + count++);
    }
  });

  private static AtomicInteger atomicInteger = new AtomicInteger();

  public static void main(String[] args) {

    new Thread(new TestCompletableFutureApp()).start();
    new Thread(new TestCompletableFutureApp()).start();
    new Thread(new TestCompletableFutureApp()).start();
    new Thread(new TestCompletableFutureApp()).start();
    new Thread(new TestCompletableFutureApp()).start();
    new Thread(new TestCompletableFutureApp()).start();
    new Thread(new TestCompletableFutureApp()).start();
    new Thread(new TestCompletableFutureApp()).start();
    new Thread(new TestCompletableFutureApp()).start();
    new Thread(new TestCompletableFutureApp()).start();
    new Thread(new TestCompletableFutureApp()).start();

  }

  @Override
  public void run() {

    int i = atomicInteger.incrementAndGet();

    List<CompletableFuture<String>> futures = Lists.newArrayList("The quick brown fox jumps over the lazy dog".trim().split(" ")).stream()
        .map(word -> CompletableFuture
            .supplyAsync(() -> {
              randomPause();
              System.out.println(word + " work: " + i + " : " + Thread.currentThread().getName());
              return word.toUpperCase();
//            })).collect(Collectors.toList());
              }, executor)).collect(Collectors.toList());

    String join = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
        .thenApply(aVoid -> futures.stream()
            .map(CompletableFuture::join)
            .collect(Collectors.joining(" "))).join();

//      String join = futures.stream()
//              .map(CompletableFuture::join)
//              .collect(Collectors.joining(" "));

    System.out.println("Work: " + i + " RESULT: " + join);
    Assert.state(true, String.valueOf("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG".equals(join)));
  }

  private static void randomPause() {
    try {
      TimeUnit.SECONDS.sleep(new Random().nextInt(5));
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }
  }
}
