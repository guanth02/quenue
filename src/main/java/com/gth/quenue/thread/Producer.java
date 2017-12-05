package com.gth.quenue.thread;


/**
 * Filename:    Producer.java  
 * Description:   
 * Copyright:   Copyright (c) 2016 All Rights Reserved.
 * Company:     guanth.co
 * @author:     guanth
 * @version:    1.0
 * Create at:   2017-12-4 下午8:45:15  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2017-12-4      guanth      1.0         1.0 Version  
 *
 */
public class Producer implements Runnable {
    private String  name;
    private Storage storage = null;

    public Producer(String name, Storage storage) {
        this.name = name;
        this.storage = storage;
    }

    public void run() {
        try {
            while (true) {
                //                Product product = new Product((int) (Math.random() * 10000)); // 产生0~9999随机整数
                String str = null;
                while (true) {
                    str = Long.toString(System.currentTimeMillis());
                    System.out.println(name + "准备生产(" + str + ").");
                    storage.push(str);
                    System.out.println(name + "已生产(" + str + ").");
                    System.out.println("===============");
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

    }
}