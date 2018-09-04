package com.imooc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author peterlee
 * @Date 2018/9/4 上午11:40
 * @Describtion :
 */
@Slf4j
public class CountDownLatchExample {

    private static int threadCount =200;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum =i;
            exec.execute(()->{
                test(threadNum);
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
            log.info("finish");
            exec.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void test(int threadNum){
        log.info("{}",threadNum);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
