package com.example.thread.test;

/**
 * ClassName: CountInsert <br/>
 * Description: <br/>
 * date: 2020/6/23 16:08<br/>
 *
 * @author zyl<br />
 */
public class CountInsert {

    private long count = 100L;

    public synchronized   void countDown() {
            while (count > 0){
                System.out.println(Thread.currentThread().getName() + "--------" + count);
                count--;
            }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                CountInsert countInsert = new CountInsert();
                countInsert.countDown();
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                CountInsert countInsert = new CountInsert();
                countInsert.countDown();
            }
        });
        thread.start();
        thread1.start();
    }
}
