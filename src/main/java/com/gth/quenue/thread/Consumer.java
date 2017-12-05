package com.gth.quenue.thread;

public class Consumer implements Runnable {
    private String name;
    private Storage storage = null;

    public Consumer(String name, Storage storage) {
        this.name = name;
        this.storage = storage;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(name + "准备消费产品.");
                String product = storage.pop();
                System.out.println(name + "已消费(" + product + ").");
                System.out.println("===============");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
