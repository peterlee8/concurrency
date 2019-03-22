package com.imooc.concurrency.classes.test;

import com.imooc.concurrency.classes.demo.Hero1;

import java.lang.reflect.Field;

/**
 * @Author peterLee
 * @CreateDate 2019/1/17
 * 通过反射修改属性的值
 *
 * getField()和getDeclaredField()的区别：
 *  两个方法都是获取字段
 *      getField 只能获取 public的，包括从父类继承来的字段
 *      和getDeclaredField可以获取本来所有的字段，包括private的，但是不能获取继承来的字段。（注：这里只能获取private字段的值，除非加上setAccessible(true)）
 */
public class Hero3Test {

    public static void main(String[] args) {
        Hero1 h =new Hero1();
        h.name="Hero3Test";
        h.setSex(1);
        try {
            //通过反射获取这个属性
            Field field = h.getClass().getField("name");
            field.set(h,"Hero3Test-update");
            System.out.println(h);
            System.out.println(h.getSex());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
