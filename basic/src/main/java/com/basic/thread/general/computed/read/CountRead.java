package com.basic.thread.general.computed.read;

import com.basic.thread.bean.CoustomerZt;
import com.basic.thread.dao.CoustomerZtDao;
import com.basic.thread.general.computed.ComputedTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @program: springboot-base
 * @description: 分段查询库
 * @author: Mr.zhang
 * @create: 2020-06-25 16:55
 **/
public class CountRead implements Callable<Integer> {

    //线程开始查询的id数量
    private long start = 0L;
    //每个线程查询的数量
    private long end = 0L;
    private List<CoustomerZt> list = new ArrayList<CoustomerZt>();
    private CoustomerZtDao coustomerZtDao = null;
    private CountDownLatch latch;

    public CountRead(long start, long end, CoustomerZtDao coustomerZtDao,CountDownLatch latch) {
        this.start = start;
        this.end = end;
        this.coustomerZtDao = coustomerZtDao;
        this.latch = latch;
    }

    @Override
    public Integer call() throws Exception {
        try {
            Map map = new HashMap<>();
            map.put("start",start);
            map.put("endPage",end);
            List list = coustomerZtDao.selectAll(map);
            ComputedTest.res.put(Thread.currentThread().getId(),list);
            return 1;
        } finally {
            latch.countDown();
        }
    }
}
