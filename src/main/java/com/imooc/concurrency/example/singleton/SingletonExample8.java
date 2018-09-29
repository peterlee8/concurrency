package com.imooc.concurrency.example.singleton;

import com.imooc.concurrency.annotations.Recommend;
import com.imooc.concurrency.annotations.ThreadSafe;

/**
 * @Author peterLee
 * @Date 2018/9/11 下午4:45
 * @Describtion : 使用延迟加载
 */
@Recommend(value = "推荐使用")
@ThreadSafe(value = "线程安全")
public class SingletonExample8 {

    private SingletonExample8(){}

    //静态内部类,做到延迟加载
    private static class SingletonHolder{
        private static SingletonExample8 instance =new SingletonExample8();
    }
    public static SingletonExample8 getInstance(){
        return SingletonHolder.instance;
    }
}
