package com.gth.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queues = new LinkedBlockingQueue<String>(99);
        int i=0;
        while(i<100){
            queues.add("123");
            i++;
        }
        
        
        String take = queues.take();
        
        System.out.println(take);
    }
}
