package com.imooc.concurrency.example.singleton;

import com.imooc.concurrency.annotations.ThreadSafe;

/**
 * @Author peterlee
 * @Date 2018/8/31 上午11:12
 * @Describtion : 懒汉模式->双重同步锁
 *  单例的实例在第一次使用时进行创建
 *
 */
@ThreadSafe(value = "引入了 volatile 保证指令顺序。")
public class SingletonExample5 {

    //单例的对象 ,添加了 "volatile" 可以限制指令重排
    private volatile static SingletonExample5 instance = null;

    /**
     * 私有构造函数
     */
    private SingletonExample5(){
    }

    // 1。memory = allocate() 分配对象内存空间
    // 2。ctorInstance  初始化对象
    // 3。instance = memory 设置 instance 的内存地址为 memory


    //静态工厂方式获取对象
    public static synchronized SingletonExample5 getInstance(){
        //多线程的时候，判断不了
        if (instance ==null){ //双重检测
            synchronized (SingletonExample5.class){
                if (instance == null){
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
