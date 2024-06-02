package com.javatechie.api.concurent.Item83;

public class ThreadSchedulerExample {

    public static void main(String[] args) {
        // Tạo hai luồng, mỗi luồng in ra 10 số từ 1 đến 10
        Thread thread1 = new Thread(new NumberPrinter("Thread 1"));
        Thread thread2 = new Thread(new NumberPrinter("Thread 2"));

        // Bắt đầu hai luồng
        thread1.start();
        thread2.start();
    }

    static class NumberPrinter implements Runnable {
        private final String threadName;

        NumberPrinter(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(threadName + ": " + i);
                try {
                    // Tạm dừng một chút để giúp thấy rõ sự xen kẽ
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
