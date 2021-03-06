package com.imooc.concurrency.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author peterlee
 * @Date 2018/8/28 下午8:56
 * @Describtion : 不推荐的类或者写法
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface UnRecommend {

    String value() default "";
}
