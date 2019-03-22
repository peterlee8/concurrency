package com.imooc.concurrency.classes.test;

import com.imooc.concurrency.classes.demo.Hero1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author peterLee
 * @CreateDate 2019/1/17
 * 通过反射创建一个对象
 */
public class HeroTest2 {

    public static void main(String[] args) {
        //传统的使用new的方式创建对象
        Hero1 hero1 =new Hero1();
        hero1.name="HeroTest2";
        System.out.println(hero1);
        try {
            //使用反射的方式创建对象
            Class<?> heroClass = Class.forName("com.imooc.concurrency.classes.demo.Hero1");
            Constructor<?> constructor = heroClass.getConstructor();
            Hero1 h = (Hero1)constructor.newInstance();
            h.name="HeroTest2-class";
            System.out.println(h);
            System.out.println(hero1==h);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
