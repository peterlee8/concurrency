package com.imooc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author peterlee
 * @Date 2018/9/4 下午12:39
 * @Describtion :
 */
@Slf4j
public class CyclicBarrierExample {

    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 10 ; i++) {
            final int threadNum =i;
            Thread.sleep(1000);
            exec.execute(()->{
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error(" exception",e);
                }
            });
        }
        exec.shutdown();
    }

    private static void race(int threadNum) throws InterruptedException, BrokenBarrierException {
        Thread.sleep(1000);
        log.info("{} is ready",threadNum);
        barrier.await(); //等待阻塞的线程执行完，继续执行
        log.info("{} continue",threadNum);
    }
}
