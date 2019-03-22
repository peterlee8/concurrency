package com.imooc.concurrency.classes.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author peterLee
 * @CreateDate 2019/1/17
 * 反射业务实现
 */
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //配置文件
        File springConfigFile = new File("C:\\ideaWorkSpace\\concurrency\\src\\main\\resources\\txt\\spring.properties");
        //java.util.Properties
        Properties properties = new Properties();
        //加载配置
        properties.load(new FileReader(springConfigFile));

        String className = (String)properties.get("class");
        String methodName = (String)properties.get("method");

        //根据类名称获取类对象
        Class<?> clazz = Class.forName(className);
        //根据方法名，获取对应的方法
        Method method = clazz.getMethod(methodName);
        //获取构造器
        Constructor<?> c = clazz.getConstructor();
        Object o = c.newInstance();
        //调用对象的指定方法
        method.invoke(o);
    }
}
