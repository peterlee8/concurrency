package com.imooc.concurrency.classes.test;

import com.imooc.concurrency.classes.demo.ExampleObject;

import java.lang.reflect.*;

/**
 * @Author peterLee
 * @CreateDate 2019/1/17
 */
public class Test5 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<ExampleObject> exampleObjectClass = ExampleObject.class;
        System.out.println("类名称："+exampleObjectClass.getSimpleName());
        System.out.println("类全名："+exampleObjectClass.getName());
        System.out.println("包路径："+exampleObjectClass.getPackage());
        System.out.println("父类："+exampleObjectClass.getSuperclass());
        //Modifier 获取类的修饰符
        System.out.println("是不是抽象类"+Modifier.isAbstract(exampleObjectClass.getModifiers()));
        System.out.println("父类是不是抽象类"+Modifier.isAbstract(exampleObjectClass.getSuperclass().getModifiers()));

        //构造器
        Constructor[] constructors = exampleObjectClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.toString());
        }
        //如果事先知道构造方法的参数
        Constructor<ExampleObject> constructor = exampleObjectClass.getConstructor(String.class);
        System.out.println("对应的构造方法"+constructor.toString());

        ExampleObject exampleObject = constructor.newInstance("123");
        System.out.println(exampleObject.toString());

        //获取变量
        Field[] fields = exampleObjectClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.println("变量:"+field.toString());
        }
        //方法
        Method method = exampleObjectClass.getMethod("setScore", Integer.class);
        method.getReturnType();
        ExampleObject exampleObject1 = exampleObjectClass.newInstance();
        method.invoke(exampleObject1,1);
        System.out.println(exampleObject1.toString());

    }
}
