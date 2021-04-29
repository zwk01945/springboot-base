package com.basic.thread.general.computed;

import com.basic.thread.ThreadApplication;
import com.basic.thread.bean.CoustomerZt;
import com.basic.thread.dao.CoustomerZtDao;
import com.basic.thread.general.computed.insert.ComputedRunnable;
import com.basic.thread.general.computed.insert.OneBillon;
import com.basic.thread.general.computed.read.CountRead;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;


/**
 * @program: springboot-base
 * @description: 线程插入测试
 * @author: Mr.zhang
 * @create: 2020-06-23 22:05
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ThreadApplication.class)
public class ComputedTest {

    private static Logger logger = LoggerFactory.getLogger(ComputedTest.class);

    @Autowired
    CoustomerZtDao coustomerZtDao;

    @Autowired
    @Qualifier("threadPoolExecutor")
    private ExecutorService service;

    public static volatile Map res = new HashMap();

    /**
     * 多线程插入数据
     * @throws InterruptedException
     */
    @Test
    public void executeInsert() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        OneBillon oneBillon = new OneBillon(coustomerZtDao);
        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            Thread each = new Thread(new ComputedRunnable(oneBillon,latch),"thread--" + i);
            //将线程放入池中进行执行
            service.execute(each);
        }
        latch.await();
        service.shutdown();
        System.out.println(Thread.currentThread().getName() + " has finished. Spend Time = " + (System.currentTimeMillis() - start) / 1000 + "s");
    }


    /**
     * 直接查询所有100W数据
     */
    @Test
    public void executeReadByOne() {
        long start = System.currentTimeMillis();
        Map map = new HashMap();
        List<CoustomerZt> coustomerZts =
                coustomerZtDao.selectAll(map);
        System.out.println((System.currentTimeMillis() - start));
    }


    /**
     * 多线程读所有100W数据
     */
    @Test
    public void executeRead() throws Exception {
        long start = System.currentTimeMillis();
        long counts = coustomerZtDao.selectCount();
        System.out.println(counts);
        //每页10W数据
        long threadSize = 200000;
        //所需线程数量
        long threads = counts / threadSize == 0 ? counts / threadSize : (counts / threadSize) + 1;
        System.out.println(threads);
        CountDownLatch latch = new CountDownLatch((int) threads);
        for (int i = 0; i < threads; i++) {
            CountRead countRead = new CountRead(i * threadSize, threadSize, coustomerZtDao,latch);
            service.submit(countRead);
        }
        latch.await();
        service.shutdown();
        System.out.println(System.currentTimeMillis() - start);
    }
}
