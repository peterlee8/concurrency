package com.imooc.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author peterlee
 * @Date 2018/9/4 下午3:30
 * @Describtion :
 */
@Slf4j
public class ThreadPoolExample2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index =i;
            executorService.execute(() ->log.info("task-{}",index));
        }
        executorService.shutdown();
    }
}
