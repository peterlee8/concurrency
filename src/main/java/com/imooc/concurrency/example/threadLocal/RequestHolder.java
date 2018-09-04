package com.imooc.concurrency.example.threadLocal;

/**
 * @Author peterlee
 * @Date 2018/8/31 下午3:53
 * @Describtion :  通过线程封闭来保证线程安全
 */
public class RequestHolder {

    private final  static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void  add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
       return requestHolder.get();
    }

    public static void remove(){
        requestHolder.remove();
    }

}

