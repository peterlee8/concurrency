package com.imooc.concurrency.example.atomic;

import com.imooc.concurrency.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author peterlee
 * @Date 2018/8/28 下午9:42
 * @Describtion : AtomicReference
 */
@Slf4j
@ThreadSafe
public class AtomicIntegerFieldUpdaterExample {

    /**
     * volatile保证可见性，并且不能是static
     */
    @Getter
    public volatile int count = 100;

    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterExample> updater
            = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterExample.class,"count");

    private static AtomicIntegerFieldUpdaterExample example = new AtomicIntegerFieldUpdaterExample();

    public static void main(String[] args) throws InterruptedException {
        if (updater.compareAndSet(example,100,200)){
            log.info("update1 success count={}",example.getCount());
        }
        if (updater.compareAndSet(example,100,400)){
            log.info("update2 success count={}",example.getCount());
        }
    }
}
