package com.imooc.concurrency.example.threadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author peterLee
 * @CreateDate 2018/10/26
 * @Description 并发场景获取唯一单号（忽略分布式环境）
 */
public class UniqueNumberUtil {

    private static final String WX="WX";

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 工单编号: WX+ 年的前两位 +月+ 日 +随机6位数
     * @return
     */
    public static String getNumber(){
        String dateString = simpleDateFormat.format(new Date());
        String substring = dateString.substring(2, 8);
        int random;
        synchronized (UniqueNumberUtil.class){
            random= (int) ((Math.random() * 9 + 1) * 100000);
        }
        return String.format("%s%s%d", WX, substring, random);
    }


    public static void main(String[] args) throws InterruptedException {
        final int thread = 10000;
        final int threadTotal = 1000;
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore =new Semaphore(threadTotal);


        Set<String> set =new LinkedHashSet<>();

        for (int i=0;i<thread;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();

                    set.add(getNumber());

                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();

        System.out.println("Set size="+set.size());

    }

}
