package com.basic.thread.general.lock;

/**
 * ClassName: SynchronizedObject <br/>
 * Description: 同步锁Bean
 * date: 2020/6/23 16:35<br/>
 *
 * @author zwk<br />
 */
public class SynchronizedObject {

    private long countParam = 100L;
    /**
     * 锁住当前对象
     */
    public void count(){
            while (true) {
                synchronized (this){
                    if (countParam > 0) {
                        System.out.println(Thread.currentThread().getName() + "----------" + countParam);
                        countParam--;
                    } else {
                        break;
                    }
                }
            }
    }

    /**
     * 锁住方法
     */
    public synchronized void countmethod(){
        while (countParam > 0) {
            System.out.println(Thread.currentThread().getName() + "----------" + countParam);
            countParam--;
        }
    }
}
