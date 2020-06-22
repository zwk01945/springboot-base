package com.example.thread.general.four;

import java.util.concurrent.TimeUnit;

/**
 * @program: springboot-base
 * @description: 中断线程
 * @author: Mr.zhang
 * @create: 2020-06-22 22:14
 **/
public class Interrupted {

    public static void main(String[] args) {

        Thread sleep = new Thread(new SleepRunner(),"sleep");
        sleep.setDaemon(true);
        Thread busy = new Thread(new BusyRunner(),"busy");
        busy.setDaemon(true);

        //启动线程
        sleep.start();
        busy.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sleep.interrupt();
        busy.interrupt();
        System.out.println("sleep :" + sleep.isInterrupted());
        System.out.println("busy :" + busy.isInterrupted());
        //防止线程提前退出
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class SleepRunner implements Runnable{

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class BusyRunner implements Runnable{

        @Override
        public void run() {
            while (true){

            }
        }
    }
}

