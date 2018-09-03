package com.imooc.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.imooc.concurrency.annotations.ThreadSafe;
import com.imooc.concurrency.annotations.ThreadUnSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * @Author peterlee
 * @Date 2018/8/31 下午2:35
 * @Describtion : 不可变集合
 */
@Slf4j
@ThreadSafe
public class ImmutableExample3 {

    private final static ImmutableList list = ImmutableList.of(1,2,3,3);
    private final static List list2 = ImmutableList.of(1,2,3,3);
    private final static ImmutableSet set =ImmutableSet.copyOf(list);

    public static void main(String[] args) {
    //    list.add(1,2);
    //    list2.add(2,2);


    }
}
