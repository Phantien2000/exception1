package com.javatechie.api.concurent.Item83;

import java.util.concurrent.CountDownLatch;

public class ThreadSchedulerExample2 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(1);

        Thread thread1 = new Thread(new NumberPrinter("Thread 1", startLatch, endLatch));
        Thread thread2 = new Thread(new NumberPrinter("Thread 2", endLatch, null));

        thread1.start();
        thread2.start();

        startLatch.countDown(); // Cho phép thread1 bắt đầu
    }

    static class NumberPrinter implements Runnable {
        private final String threadName;
        private final CountDownLatch startLatch;
        private final CountDownLatch endLatch;

        NumberPrinter(String threadName, CountDownLatch startLatch, CountDownLatch endLatch) {
            this.threadName = threadName;
            this.startLatch = startLatch;
            this.endLatch = endLatch;
        }

        @Override
        public void run() {
            try {
                if (startLatch != null) {
                    startLatch.await(); // Chờ cho đến khi startLatch đếm xuống 0
                }
                for (int i = 1; i <= 10; i++) {
                    System.out.println(threadName + ": " + i);
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                if (endLatch != null) {
                    endLatch.countDown(); // Đếm xuống endLatch khi kết thúc
                }
            }
        }
    }
}
