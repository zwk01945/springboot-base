package com.example.thread.general.four;

import java.util.concurrent.TimeUnit;

/**
 * @program: springboot-base
 * @description: 守护线程
 * @author: Mr.zhang
 * @create: 2020-06-22 21:56
 **/
public class DaemonThread {


    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonTest());
        //设置为守护线程
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonTest implements Runnable{
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("守护线程中的finally代码");
            }
        }
    }
}
