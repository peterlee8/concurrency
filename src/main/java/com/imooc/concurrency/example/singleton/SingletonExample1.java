package com.imooc.concurrency.example.singleton;

import com.imooc.concurrency.annotations.ThreadUnSafe;

/**
 * @Author peterlee
 * @Date 2018/8/31 上午11:12
 * @Describtion : 懒汉模式
 *  单例的实例在第一次使用时进行创建
 */
@ThreadUnSafe
public class SingletonExample1 {

    //单例的对象
    private static SingletonExample1 instance = null;

    /**
     * 私有构造函数
     */
    private SingletonExample1(){
    }
    //静态工厂方式获取对象
    public static SingletonExample1 getInstance(){
        //多线程的时候，判断不了
        if (instance ==null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
