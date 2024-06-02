package com.javatechie.api.concurent.Item81;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class BoundedBuffer {
    private final BlockingQueue<Object> queue = new ArrayBlockingQueue<>(100);

    public void put(Object x) throws InterruptedException {
        queue.put(x);
    }

    public Object take() throws InterruptedException {
        return queue.take();
    }
}
