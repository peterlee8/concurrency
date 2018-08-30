package com.imooc.concurrency.example.count;

import com.imooc.concurrency.annotations.ThreadSafe;
import com.imooc.concurrency.annotations.ThreadUnSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author peterlee
 * @Date 2018/8/28 下午9:42
 * @Describtion :
 */
@Slf4j
@ThreadSafe
public class ConcurrencyExample2 {

    //总的请求数量
    public  static int clientTotal =5000;
    //同时并发的线程数量
    public  static int threadTotal =200;
    //计数器
    public  static  AtomicInteger count=  new AtomicInteger(5000) ;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量，运行并发的最大值
        final Semaphore semaphore =new Semaphore(threadTotal);
        //计数器闭锁
        final CountDownLatch countDownLatch =new CountDownLatch(clientTotal);
        for (int i = 0; i <clientTotal ; i++) {
            executorService.execute(()->{
                try {
                    //判断当前并发是否超过指定最大值，超过->等待
                    semaphore.acquire();
                    add();
                    //释放线程
                    semaphore.release();
                } catch (Exception e) {
                   log.error("Exception",e);
                }
                //计数减一
                countDownLatch.countDown();
            });
        }
        //阻塞主线程，直到 countDownLatch 计数器减为0
        countDownLatch.await();
        //关闭线程池
        executorService.shutdown();
        log.info("count={}",count.get());
    }
    private static void add(){
        //  先自增再返回
        count.decrementAndGet();
    }

}
