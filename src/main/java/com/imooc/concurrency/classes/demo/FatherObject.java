package com.imooc.concurrency.classes.demo;

/**
 * @Author peterLee
 * @CreateDate 2019/1/17
 *
 */
public abstract class FatherObject implements Runnable {

    public void doSomething(){
        System.out.println("做事情......");
    }
}
