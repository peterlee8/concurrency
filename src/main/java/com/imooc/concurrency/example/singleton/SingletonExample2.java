package com.imooc.concurrency.example.singleton;

import com.imooc.concurrency.annotations.ThreadSafe;

/**
 * @Author peterlee
 * @Date 2018/8/31 上午11:12
 * @Describtion : 饿汉模式
 *  单例的实例在类装载的时候创建
 */
@ThreadSafe
public class SingletonExample2 {

    //单例的对象
    private static SingletonExample2 instance = new SingletonExample2();

    /**
     * 私有构造函数 :
     * 不足：如果初始化的时候构造函数操作过多。导致类加载很慢，可能会引起性能问题
     */
    private SingletonExample2(){

    }
    //静态工厂方式获取对象
    public static SingletonExample2 getInstance(){
        return instance;
    }
}
