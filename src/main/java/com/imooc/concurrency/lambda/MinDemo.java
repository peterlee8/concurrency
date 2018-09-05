package com.imooc.concurrency.lambda;

import java.util.stream.IntStream;

/**
 * @Author peterlee
 * @Date 2018/9/5 下午12:28
 * @Describtion : 求最小值
 */
public class MinDemo {

    public static void main(String[] args) {
        int[] nums={-666,-590,-450,-34,0,231,435,653};
        //java 8
        int asInt = IntStream.of(nums).parallel().min().getAsInt();
        System.out.println(asInt);
    }

}
