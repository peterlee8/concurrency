package com.imooc.concurrency.example.threadLocal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author peterLee
 * @CreateDate 2018/10/29
 * @Description
 */
public class ThreadLocalDemo {
    private static ThreadLocal<Integer> threadData =new ThreadLocal<>();

    public static void main(String[] args) {
       /* Demo.WordThread wordThread1 =new Demo.WordThread(threadData);
        Demo.WordThread wordThread2 =new Demo.WordThread(threadData);
        wordThread1.start();
        wordThread2.start();*/

        System.out.println(Thread.currentThread().getName()+" 执行完毕");
    }


    static class WordThread extends Thread{
        private ThreadLocal<Integer> threadLocal;

        public WordThread(ThreadLocal<Integer> threadData){
            this.threadLocal = threadData;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("WordThread:"+Thread.currentThread().getName());
            int dataIn =new Random().nextInt(10);
            //存放数据，这里之所以加个锁，是因为个别情况下因为并发原因导致integerMap.put() 的key突然变为其他线程，则会导致get错误，Map线程不安全，注意
            threadLocal.set(dataIn);
            //获取数据
            /*Integer integer = threadLocal.get(Thread.currentThread());
            System.out.println("Thread.currentThread(), key="+Thread.currentThread().getName()+",value:"+integer);*/
        }
    }
}
