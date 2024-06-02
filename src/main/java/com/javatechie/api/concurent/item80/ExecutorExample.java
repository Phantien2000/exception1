package com.javatechie.api.concurent.item80;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                System.out.println("Hello from thread " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}

