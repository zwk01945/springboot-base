package com.example.thread.general.threadlocal;

import java.util.concurrent.CountDownLatch;

/**
 * @program: springboot-base
 * @description: 不同线程访问同一类变量带Threadlocal
 * @author: Mr.zhang
 * @create: 2020-06-22 20:57
 **/
public class ThreadDiffofLocal {
    private static final ThreadLocal<String> thread = new ThreadLocal<String>();

    public String getThread() {
        return thread.get();
    }

    public void setThread(String local) {
        thread.set(local);
    }


    public static void main(String[] args) {
        ThreadDiffofLocal diff = new ThreadDiffofLocal();
        int threads = 10;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    diff.setThread(Thread.currentThread().getName());
                    System.out.println(diff.getThread());
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }
    }
}
