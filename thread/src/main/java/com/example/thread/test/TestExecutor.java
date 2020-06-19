package com.example.thread.test;


public class TestExecutor implements Runnable {

    @Override
    public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread" + Thread.currentThread().getName() +"-----值-----"+i);
            }
    }

}
