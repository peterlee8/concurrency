package com.imooc.concurrency.lambda;


/**
 * @Author peterlee
 * @Date 2018/9/5 下午12:36
 * @Describtion :
 */
public class LambdaDemo1 {

    public static void main(String[] args) {
        Interface1 i1 =(i)-> i*2;

        Interface1 i2 =(int i)-> i*2;
        //最常见的写法
        Interface1 i3 =i -> i*2;

        System.out.println();
    }
}

@FunctionalInterface
interface Interface1{
    int doubleNum(int i);
}
