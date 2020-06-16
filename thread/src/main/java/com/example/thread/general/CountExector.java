package com.example.thread.general;


import java.util.concurrent.Callable;

public class CountExector implements Callable {

    public  static ThreadLocal<Integer> count = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };


    public void countSum() {

        try {
            for (int i = 0; i < 10; i++) {
                count.set(count.get() + 1);
                System.out.println(Thread.currentThread().getName()+"--"+count.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public Object call() throws Exception {
        countSum();
        return count.get();
    }
}
