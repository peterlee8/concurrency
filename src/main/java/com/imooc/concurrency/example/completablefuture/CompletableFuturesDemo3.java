package com.imooc.concurrency.example.completablefuture;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 *  java8  CompletableFuture
 */
public class CompletableFuturesDemo3 {

    /**
     * 12701
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        //结果集
        List<Integer> taskList =new ArrayList<>();
        List<Integer> list =new ArrayList<>();

        if (200==0){
            return;
        }
        for (int i = 0; i <200 ; i++) {
            taskList.add(i+1);
        }
        taskList.parallelStream().map(integer -> {
            list.add(sleep(integer));
            return null;
        }).collect(Collectors.toList());

        System.out.println("list="+list+",耗时="+(System.currentTimeMillis()-start));

    }


    public static Integer calc(Integer i) {
        try {
            if (i == 1) {
            Thread.sleep(3000);
            //任务1耗时3秒
             } else if (i == 5) {
             Thread.sleep(5000);
             //任务5耗时5秒
             } else {
                Thread.sleep(1000);
            //其它任务耗时1秒
            }
            System.out.println("task线程：" + Thread.currentThread().getName()+ "任务i=" + i + ",完成！+" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static Integer sleep(Integer integer){
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return integer+1;
    }
}
