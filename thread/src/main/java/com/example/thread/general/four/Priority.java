package com.example.thread.general.four;

import com.example.thread.ThreadApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.management.ThreadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: thread
 * @description: 线程优先级
 * @author: Mr.zhang
 * @create: 2020-06-21 07:47
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ThreadApplication.class)
public class Priority {
    private volatile boolean notStart = true;
    private volatile boolean notEnd = true;

    @Test
    public void testPriority () throws InterruptedException {

        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int priority = i < 5? Thread.MIN_PRIORITY: Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job,"thread" + i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;
        for (Job job: jobs){
            System.out.println("Job Proirity:" +job.priority + ", count:" + job.jobCount);
        }

    }


    class Job implements  Runnable{
        private int priority;
        private long jobCount;
        public Job(int priority){
            this.priority = priority;
        }
        @Override
        public void run() {
            while (notStart){
                Thread.yield();
            }
            while (notEnd){
                Thread.yield();
                jobCount++;
            }
        }
    }
}
