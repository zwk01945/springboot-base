package com.example.thread.general.computed.insert;

import java.util.concurrent.CountDownLatch;

/**
 * @program: springboot-base
 * @description: 插入接口线程
 * @author: Mr.zhang
 * @create: 2020-06-23 21:38
 **/
public class ComputedRunnable implements Runnable {

    OneBillon oneBillon = null;
    private CountDownLatch latch = null;

    public ComputedRunnable(OneBillon oneBillon,CountDownLatch latch) {
        this.oneBillon = oneBillon;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            oneBillon.countInsert();
        } finally {
            latch.countDown();
        }
    }
}
