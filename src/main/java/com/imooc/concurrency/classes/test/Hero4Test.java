package com.imooc.concurrency.classes.test;

import com.imooc.concurrency.classes.demo.Hero1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author peterLee
 * @CreateDate 2019/1/17
 * 通过反射获取类对象的方法
 */
public class Hero4Test {

    public static void main(String[] args) {
        Class<Hero1> aClass = Hero1.class;
        try {
            Method setName = aClass.getMethod("setName", String.class);
            Constructor<Hero1> constructor = aClass.getConstructor();
            Hero1 hero1 = constructor.newInstance();
            setName.invoke(hero1,"盖伦");
            System.out.println(hero1.name);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {


        }
    }
}
