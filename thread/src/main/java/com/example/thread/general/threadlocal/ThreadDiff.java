package com.example.thread.general.threadlocal;

import java.util.concurrent.CountDownLatch;

/**
 * @program: springboot-base
 * @description: 不同线程访问同一类变量
 * @author: Mr.zhang
 * @create: 2020-06-22 20:30
 **/
public class ThreadDiff {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        int threads = 10;
        ThreadDiff diff = new ThreadDiff();
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    diff.setName(Thread.currentThread().getName());
                    System.out.println(diff.getName());
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }
    }
}
