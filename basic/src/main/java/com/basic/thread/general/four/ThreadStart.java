package com.basic.thread.general.four;

import java.util.concurrent.FutureTask;

/**
 * @program: springboot-base
 * @description: 线程创建和启动方式
 * @author: Mr.zhang
 * @create: 2020-06-22 22:36
 **/
public class ThreadStart extends Thread{

    public static void main(String[] args) {
        Thread thread = new ThreadStart();
        Thread runner = new Thread(new RunnableClass());
        FutureTask task = new FutureTask(new CallableClass());
        Thread callable = new Thread(task);

        thread.start();
        runner.start();
        callable.start();
    }

    @Override
    public void run() {
        System.out.println("thread类的方法");
    }


    static class RunnableClass implements Runnable{

        @Override
        public void run() {
            System.out.println("runnable");
        }
    }


    static class CallableClass implements java.util.concurrent.Callable{

        @Override
        public Object call() throws Exception {
            System.out.println("callable");
            return null;
        }
    }
}
