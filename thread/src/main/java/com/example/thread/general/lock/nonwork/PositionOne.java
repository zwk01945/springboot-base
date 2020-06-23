package com.example.thread.general.lock.nonwork;

import com.example.thread.general.lock.SynchronizedObject;

/**
 * ClassName: PositionOne <br/>
 * Description: 在run方法中去创建对象在去调用对象中方法内部加锁
 * date: 2020/6/23 16:43<br/>
 *
 * @author zyl<br />
 */
public class PositionOne implements Runnable{

    @Override
    public void run() {
        SynchronizedObject object = new SynchronizedObject();
        object.count();
    }

    public static void main(String[] args) {
        Thread th1 = new Thread(new PositionOne());
        Thread th2 = new Thread(new PositionOne());
        th1.start();
        th2.start();
    }
}
