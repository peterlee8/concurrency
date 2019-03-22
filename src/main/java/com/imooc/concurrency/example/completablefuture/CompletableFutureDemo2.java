package com.imooc.concurrency.example.completablefuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  java8  CompletableFuture
 */
@SuppressWarnings(value = "all")
public class CompletableFutureDemo2 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        //结果集
        List<String> list = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Integer> taskList = new ArrayList<>();
        for (int i = 0; i <200 ; i++) {
            taskList.add(i+1);
        }
        //全流式处理转换成CompletableFuture[]+组成一个无返回值CompletableFuture,join 等待执行完毕。返回结果wheComplete获取
        CompletableFuture[] cfs = taskList.stream().map(
                integer -> {
                  return  CompletableFuture.supplyAsync(() -> sleep(integer), executorService)
                            .thenApply(h -> Integer.toString(h))
                            .whenComplete((s, e) -> {
                                System.out.println("任务" + s + "完成!result=" + s + "，异常 e=" + e + "," + new Date());
                                list.add(s);
                            });
                }).toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(cfs).join();

        System.out.println("size="+list.size()+" list="+list+",耗时="+(System.currentTimeMillis()-start));

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
