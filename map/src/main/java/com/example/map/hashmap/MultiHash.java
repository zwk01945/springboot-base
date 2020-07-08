package com.example.map.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MultiHash <br/>
 * Description: <br/>
 * date: 2020/7/8 13:55<br/>
 *
 * @author zwk<br />
 */
public class MultiHash{

    public static void main(String[] args) {
        Map<Integer,Object> each = new HashMap<>();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 25; i++) {
                    each.put(i,i);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 25; i < 50; i++) {
                    each.put(i,i);
                }
            }
        });


        thread1.start();
        thread2.start();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 50; i++) {
            if (each.get(i).equals(i)) {
                System.out.println(i);
            }
        }

    }

}
