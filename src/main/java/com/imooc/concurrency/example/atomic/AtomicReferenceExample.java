package com.imooc.concurrency.example.atomic;

import com.imooc.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Author peterlee
 * @Date 2018/8/28 下午9:42
 * @Describtion : AtomicReference
 */
@Slf4j
@ThreadSafe
public class AtomicReferenceExample {

    //总的请求数量
    public  static int clientTotal =5000;
    //同时并发的线程数量
    public  static int threadTotal =200;
    //计数器
    public  static AtomicReference<Integer> count=  new AtomicReference(0) ;

    public static void main(String[] args) throws InterruptedException {
        count.compareAndSet(0,1); //count=1
        count.compareAndSet(0,2); //count=1
        count.compareAndSet(1,3); //count=3
        count.compareAndSet(2,4); //count=3
        count.compareAndSet(3,5); //count=5
        log.info("count={}",count.get());
    }
    private static void add(){

    }

}
