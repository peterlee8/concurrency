package com.imooc.concurrency.example.singleton;

import com.imooc.concurrency.annotations.Recommend;
import com.imooc.concurrency.annotations.ThreadSafe;

/**
 * @Author peterlee
 * @Date 2018/8/31 上午11:12
 * @Describtion : 枚举模式
 * 单例的实例在实际调用之前创建(保证安全和性能)
 *
 */
@ThreadSafe
@Recommend(value = "推荐的做法")
public class SingletonExample7 {

    /**
     * 私有构造函数
     */
    private SingletonExample7(){
    }

    //单例的对象 ,添加了 "volatile" 可以限制指令重排
    private volatile static SingletonExample7 instance = null;

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getSingleton();
    }
    //通过私有的枚举，保证实例被调用前只被初始化一次
    private enum Singleton{
        INSTANCE;
        private SingletonExample7 singleton;
        //枚举构造函数，JVM保证这个方法绝对只调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getSingleton(){
            return singleton;
        }
    }



}
