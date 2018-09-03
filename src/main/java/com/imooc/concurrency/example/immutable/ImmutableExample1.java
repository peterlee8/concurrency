package com.imooc.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.imooc.concurrency.annotations.ThreadUnSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @Author peterlee
 * @Date 2018/8/31 下午2:35
 * @Describtion : 被final修饰的变量基础数据类型不可修改
 *                被final修饰的对象不可进行另外的指向
 */
@Slf4j
@ThreadUnSafe
public class ImmutableExample1 {

    private final static Integer a=1;
    private final static String b="2";
    private final static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
//       a=2;
//       b= "3";
//        HashMap<Integer, Integer> map2 = Maps.newHashMap();
//        map =map2;
    }
}
