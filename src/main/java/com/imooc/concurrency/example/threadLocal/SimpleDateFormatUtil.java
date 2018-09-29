package com.imooc.concurrency.example.threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author peterLee
 * @Date 2018/9/11 下午4:39
 * @Describtion :  通过ThreadLocal 来初始化缓存常用的代码类 ，而且不是线程安全的
 */
public class SimpleDateFormatUtil {

    private static ThreadLocal<SimpleDateFormat> dateFormatHolder = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static void main(String[] args) {
        String format = dateFormatHolder.get().format(new Date());
        System.out.println(format);
    }
}
