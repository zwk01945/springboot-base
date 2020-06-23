package com.example.thread.general.computed;

/**
 * @program: springboot-base
 * @description: 插入接口线程
 * @author: Mr.zhang
 * @create: 2020-06-23 21:38
 **/
public class ComputedRunnable implements Runnable {

    OneBillon oneBillon = null;

    public ComputedRunnable(OneBillon oneBillon) {
        this.oneBillon = oneBillon;
    }

    @Override
    public void run() {
        oneBillon.countInsert();
    }
}
