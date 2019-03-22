package com.imooc.concurrency.classes.test;

import com.imooc.concurrency.classes.demo.Hero1;

/**
 * @Author peterLee
 * @CreateDate 2019/1/17
 */
public class Hero1Test {

    public static void main(String[] args) {
        try {
            Class<?> hero1 = Class.forName("com.imooc.concurrency.classes.demo.Hero1");
            Class<Hero1> aClass = Hero1.class;
            System.out.println(hero1==aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
