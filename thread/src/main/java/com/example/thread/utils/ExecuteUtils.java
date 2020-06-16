package com.example.thread.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * 线程池工具类
 */
@Component
public class ExecuteUtils<E> {

    private static Logger logger = LoggerFactory.getLogger(ExecuteUtils.class);

    @Autowired
    @Qualifier("threadPoolExecutor")
    private ExecutorService service;

    /**
     * 根据反射创建实例对象
     * @param clz
     * @param o
     * @param <T>
     * @return
     */
    public  <T> T get(Class<T> clz,Object o){
        if(clz.isInstance(o)){
            return clz.cast(o);
        }
        return null;
    }

    /**
     * 提交并且释放线程资源
     * @param
     */
    public Object submit(Class<E> clazz, Object obj) throws Exception {
        E e = get(clazz, obj);
        if (e == null) throw new NullPointerException("creat obj is fail please check it...");
        Future<?> submit = null;
        logger.info("线程开始提交并处理------");
        final long startTime = System.currentTimeMillis();
        if (e instanceof Runnable) {
            Runnable  runnable  =  (Runnable)e;
            submit = service.submit(runnable);
        } else if (e instanceof Callable) {
            Callable<E> callable = (Callable) e;
            submit = service.submit(callable);
        }
        if (submit == null) throw new NullPointerException("return value is null");
        if (submit.isDone()) {
            service.shutdown();
            logger.info("线程结束,共耗时:"+(System.currentTimeMillis()-startTime)/1000.0+"s");
        }
        return submit.get();
    }



}
