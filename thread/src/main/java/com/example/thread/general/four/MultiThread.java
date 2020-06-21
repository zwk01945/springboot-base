package com.example.thread.general.four;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 查看main程序包括的线程
 * @Date 2020年6月21日 07点10分
 */
public class MultiThread {

    public static void main(String[] args) {
        //获取java线程管理的Mxbean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //获取线程和线程堆栈信息,不获取同步的monitors和synchronized
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        //遍历线程信息，打印id和名称
        for (ThreadInfo info :threadInfos) {
            System.out.println("[" + info.getThreadId() + "] " + info.getThreadName());
        }
    }

}
