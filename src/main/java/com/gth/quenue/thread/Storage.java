package com.gth.quenue.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Filename:    Storage.java  
 * Description: 用户存放生产出来的数据
 * Copyright:   Copyright (c) 2016 All Rights Reserved.
 * Company:     
 * @author:     关体华
 * @version:    1.0
 * Create at:   2017-12-4 上午9:07:12  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 * 2017-12-4      关体华      1.0         1.0 Version  
 *
 */
public class Storage {
    //主仓库  
    BlockingQueue<String> queues     = new LinkedBlockingQueue<String>(10);
    //临时仓库 用于存放正在推送中的数据
    BlockingQueue<String> tempQueues = new LinkedBlockingQueue<String>(10);

    /**
     * @Description: 
     * @author 关体华
     * @param product
     * @throws InterruptedException 
     * @date: 2017-12-4 上午9:06:36
     */
    public void push(String product) throws InterruptedException {
        //校验主仓库和临时仓库中是否存在相同的数据，有则舍弃
        if (queues.contains(product) && tempQueues.contains(product)) {
            return;
        }
        queues.put(product);
    }

    /**
     * @Description: 
     * @author 关体华
     * @return
     * @throws InterruptedException 
     * @date: 2017-12-4 上午9:06:42
     */
    public String pop() throws InterruptedException {
        return queues.take();
    }
}
