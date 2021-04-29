package com.basic.map.concurrentHashMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: MultiConcurrentHash <br/>
 * Description: <br/>
 * date: 2020/7/8 14:16<br/>
 *
 * @author zwk<br />
 */
public class MultiConcurrentHash {

    public static void main(String[] args) {

        Map<Integer,Object>  map = new ConcurrentHashMap<>();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 25; i++) {
                    map.put(i,i);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 25; i < 50; i++) {
                    map.put(i,i);
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 50; i++) {
            System.out.println(map.get(i));
        }

    }


}
