package com.gth.quenue.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.gth.quenue.thread.Consumer;
import com.gth.quenue.thread.Producer;
import com.gth.quenue.thread.Storage;

public class App {
    public static void main(String[] args) {
        Storage storage = new Storage();

        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer = new Producer("生产者张三", storage);

        Consumer consumer = new Consumer("消费者李四", storage);

        service.submit(producer);
        service.submit(consumer);
    }
}
