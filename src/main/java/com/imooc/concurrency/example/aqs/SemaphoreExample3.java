package com.imooc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author peterlee
 * @Date 2018/9/4 上午11:40
 * @Describtion :
 */
@Slf4j
public class SemaphoreExample3 {

    private static int threadCount =200;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore =new Semaphore(5);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum =i;
            exec.execute(()->{
                try {
                    if (semaphore.tryAcquire()){ //尝试得到许可
                        test(threadNum);
                        semaphore.release(); //释放
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        log.info("finish");
        exec.shutdown();

    }
    private static void test(int threadNum) throws InterruptedException {
        log.info("{}",threadNum);
        Thread.sleep(1000);
    }
}
