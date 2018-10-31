package com.imooc.concurrency.example.threadLocal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author peterLee
 * @CreateDate 2018/10/29
 * @Description   Map版
 */
public class Demo {

    private static Map<Thread,Integer> threadData =new HashMap<>();

    public static void main(String[] args) {
        WordThread wordThread1 =new WordThread(threadData);
        WordThread wordThread2 =new WordThread(threadData);
        wordThread1.start();
        wordThread2.start();

        System.out.println(Thread.currentThread().getName()+" 执行完毕");
    }


    static class WordThread extends Thread{
        private Map<Thread,Integer> integerMap;

        public WordThread(Map<Thread,Integer> threadData){
            this.integerMap = threadData;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("WordThread:"+Thread.currentThread().getName());
            int dataIn =new Random().nextInt(10);
            //存放数据，这里之所以加个锁，是因为个别情况下因为并发原因导致integerMap.put() 的key突然变为其他线程，则会导致get错误，Map线程不安全，注意
            synchronized (integerMap){
                integerMap.put(Thread.currentThread(),dataIn);
            }

            //获取数据
            Integer integer = integerMap.get(Thread.currentThread());
            System.out.println("Thread.currentThread(), key="+Thread.currentThread().getName()+",value:"+integer);
        }
    }

}
