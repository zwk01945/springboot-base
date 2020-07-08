//package com.example.thread.general;
//
//import com.example.thread.ThreadApplication;
//import com.example.thread.common.CustomeRejectedExecutionHandler;
//import com.example.thread.test.TestExecutor;
//import org.junit.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.concurrent.*;
//
//
//@SpringBootTest(classes = ThreadApplication.class)
//public class TestExecutorTest {
//
//    ExecutorService executorService = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10), Executors.defaultThreadFactory(),new CustomeRejectedExecutionHandler());
//
//    /**
//     * 测试普通实现runable接口输出线程名
//     */
//    @Test
//    public void test() {
//        TestExecutor testExecutor = new TestExecutor();
//        executorService.execute(testExecutor);
//        executorService.shutdown();
//    }
//
//    public static void main(String[] args) {
//        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10), Executors.defaultThreadFactory(),new CustomeRejectedExecutionHandler());
//
//        TestExecutor testExecutor = new TestExecutor();
//        executorService.execute(testExecutor);
//    }
//
//    /**
//     * 多线程共享变量
//     */
//    @Test
//    public void countTest() {
//
//    }
//}