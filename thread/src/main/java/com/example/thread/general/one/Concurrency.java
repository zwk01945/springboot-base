package com.example.thread.general.one;

import com.example.thread.ThreadApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName: Concurrency
 * Description: 串行执行和并发执行比较
 * date: 2020/6/19 15:33
 * @author Mr.zhang
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ThreadApplication.class)
public class Concurrency {
    /** 控制循环次数 */
    private final long count = 50000000L;

    //并发
    private void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        thread.join();
        long time = System.currentTimeMillis() -start;
        System.out.println("currency :" + time + "ms,b=" + b );
    }


    //串行
    private void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() -start;
        System.out.println("serial :" + time + "ms,b=" + b + ",a=" + a);
    }

    @Test
    public void common() throws InterruptedException {
        concurrency();
        serial();
    }
}
