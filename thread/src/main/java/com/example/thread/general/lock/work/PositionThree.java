package com.example.thread.general.lock.work;

import com.example.thread.general.lock.SynchronizedObject;
import com.example.thread.general.lock.nonwork.PositionOne;
import com.example.thread.utils.ExecuteUtils;

/**
 * ClassName: PositionThree <br/>
 * Description: <br/>
 * date: 2020/6/23 17:45<br/>
 *
 * @author zyl<br />
 */
public class PositionThree implements Runnable{

    SynchronizedObject object = null;

    public PositionThree(SynchronizedObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.count();
    }

    public static void main(String[] args) {
        SynchronizedObject object = new SynchronizedObject();
        Thread th1 = new Thread(new PositionThree(object));
        Thread th2 = new Thread(new PositionThree(object));
        th1.start();
        th2.start();
    }
}
