package com.basic.thread.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.*;

@SpringBootConfiguration
@ConfigurationProperties(prefix = "threadpool")
public class ThreadConfig {

    Logger logger = LoggerFactory.getLogger(ThreadConfig.class);

    private int corePoolSize;
    private int maxPoolSize;
    private int queueCapacity;
    private int keepAliveSeconds;

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public int getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

    public void setKeepAliveSeconds(int keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }

    @Bean("threadPoolExecutor")
    public ExecutorService executorService() {
        logger.info("ThreadPool参数为:{},{},{},{}",corePoolSize,maxPoolSize,queueCapacity,keepAliveSeconds);
        return new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveSeconds, TimeUnit.SECONDS,new ArrayBlockingQueue<>(queueCapacity),new CustomeRejectedExecutionHandler());
    }

}
