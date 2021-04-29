package com.basic.thread.general.four;

import com.basic.thread.ThreadApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @program: springboot-base
 * @description: 线程状态
 * @author: Mr.zhang
 * @create: 2020-06-21 08:30
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ThreadApplication.class)
public class ThreadState {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "timeWaiting").start();
        new Thread(new Waiting(),"waiting").start();
        new Thread(new Blocked(),"blocked-1").start();
        new Thread(new Blocked(),"blocked-2").start();
    }

    //超时等待
    static class TimeWaiting implements Runnable{
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //该线程在Waiting上等待
    static class Waiting implements Runnable{

        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class){
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}

    //该线程在Blocked上加锁之后不会释放锁
    static class Blocked implements Runnable{

        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
