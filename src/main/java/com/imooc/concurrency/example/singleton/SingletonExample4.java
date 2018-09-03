package com.imooc.concurrency.example.singleton;

import com.imooc.concurrency.annotations.ThreadUnSafe;

/**
 * @Author peterlee
 * @Date 2018/8/31 上午11:12
 * @Describtion : 懒汉模式->双重同步锁
 *  单例的实例在第一次使用时进行创建
 *
 */
@ThreadUnSafe(value = "线程非安全")
public class SingletonExample4 {

    //单例的对象
    private static SingletonExample4 instance = null;

    /**
     * 私有构造函数
     */
    private SingletonExample4(){
    }

    // 1。memory = allocate() 分配对象内存空间
    // 2。ctorInstance  初始化对象
    // 3。instance = memory 设置 instance 的内存地址为 memory

    // 可能发生的不安全：
    //JVM和cpu优化。发生了指令重排：
        // 1。memory = allocate() 分配对象内存空间
        // 3。instance = memory 设置 instance 的内存地址为 memory
        // 2。ctorInstance  初始化对象


    //静态工厂方式获取对象
    public static synchronized SingletonExample4 getInstance(){
        //多线程的时候，判断不了
        if (instance ==null){ //双重检测                 //->B线程，此时直接返回。没有进行 ctorInstance
            synchronized (SingletonExample4.class){
                if (instance == null){
                    instance = new SingletonExample4(); // -> A 线程
                }
            }
        }
        return instance;
    }
}
