package com.imooc.concurrency.example.singleton;

import com.imooc.concurrency.annotations.ThreadSafe;

/**
 * @Author peterlee
 * @Date 2018/8/31 上午11:12
 * @Describtion : 懒汉模式->双重同步锁
 *  单例的实例在第一次使用时进行创建
 *
 */
@ThreadSafe
public class SingletonExample6 {

    /**
     * 私有构造函数
     */
    private SingletonExample6(){
    }

    //单例的对象 ,添加了 "volatile" 可以限制指令重排
    private volatile static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    //静态工厂方式获取对象
    public static  SingletonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());

    }


}
