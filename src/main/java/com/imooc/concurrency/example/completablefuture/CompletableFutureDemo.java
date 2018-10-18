package com.imooc.concurrency.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 *  java8  CompletableFuture
 */
public class CompletableFutureDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
                System.out.println(" task doing ...");
            return "ok";
        });
        String s = completableFuture.get();
        System.out.printf("result :%s%n", s);
    }



}
