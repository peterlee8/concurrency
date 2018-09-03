package com.imooc.concurrency.example.singleton;

import com.imooc.concurrency.annotations.ThreadSafe;
import com.imooc.concurrency.annotations.UnRecommend;

/**
 * @Author peterlee
 * @Date 2018/8/31 上午11:12
 * @Describtion : 懒汉模式
 *  单例的实例在第一次使用时进行创建
 */
@ThreadSafe
@UnRecommend(value = "这种写法，不推荐。性能开销")
public class SingletonExample3 {

    //单例的对象
    private static SingletonExample3 instance = null;

    /**
     * 私有构造函数
     */
    private SingletonExample3(){
    }
    //静态工厂方式获取对象
    public static synchronized SingletonExample3 getInstance(){
        //多线程的时候，判断不了
        if (instance ==null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
