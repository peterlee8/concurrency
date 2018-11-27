package com.imooc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Author peterlee
 * @Date 2018/9/4 上午11:40
 * @Describtion :
 */
@Slf4j
@SuppressWarnings(value = "all")
public class CountDownLatchExample2 {

    private static int threadCount =200;

    private static ExecutorService excutor =new ThreadPoolExecutor(0,200,60l, TimeUnit.SECONDS,new ArrayBlockingQueue(10));

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum =i;
            excutor.execute(()->{
                test(threadNum);
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
            log.info("finish");
            excutor.shutdown();
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
