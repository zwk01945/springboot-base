package com.basic.thread.general.lock.nonwork;

import com.basic.thread.general.lock.SynchronizedObject;

/**
 * ClassName: PositionTwo <br/>
 * Description: 在run方法中去创建对象在去调用对象中方法加锁
 * date: 2020/6/23 16:57<br/>
 *
 * @author zyl<br />
 */
public class PositionTwo implements Runnable{

    @Override
    public void run() {
        SynchronizedObject object = new SynchronizedObject();
        object.countmethod();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new PositionTwo());
        Thread thread1 = new Thread(new PositionTwo());
        thread.start();
        thread1.start();
    }
}
