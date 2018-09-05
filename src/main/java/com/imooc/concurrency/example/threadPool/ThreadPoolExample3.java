package com.imooc.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author peterlee
 * @Date 2018/9/4 下午3:30
 * @Describtion :
 */
@Slf4j
public class ThreadPoolExample3 {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
         executorService.schedule(() -> {
            log.warn(" schedule run");
         },3, TimeUnit.SECONDS);
        executorService.shutdown();
    }
}
