package com.example.thread.common;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 该自定义方法会有多少都会添加到队列
 * @param <T>
 */
public class CustomeBlockingQueue<T> extends LinkedBlockingQueue<T> {

    private static final long serialVersionUID = 1L;

    public CustomeBlockingQueue(int size) {
        super(size);
    }

    @Override
    public boolean offer(T o) {

        try {
            put(o);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        return false;
    }
}
