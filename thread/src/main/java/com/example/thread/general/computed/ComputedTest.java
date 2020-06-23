package com.example.thread.general.computed;

import com.example.thread.ThreadApplication;
import com.example.thread.dao.CoustomerZtDao;
import com.example.thread.utils.ExecuteUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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


    @Test
    public void execute(){
        OneBillon oneBillon = new OneBillon(coustomerZtDao);
        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new Thread(new ComputedRunnable(oneBillon),"a");
        Thread t2 = new Thread(new ComputedRunnable(oneBillon),"b");
        Thread t3 = new Thread(new ComputedRunnable(oneBillon),"c");

        //将线程放入池中进行执行
        service.execute(t1);
        service.execute(t2);
        service.execute(t3);
    }
}
