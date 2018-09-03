package com.imooc.concurrency.example.publish;

import com.imooc.concurrency.annotations.ThreadUnSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author peterlee
 * @Date 2018/8/31 上午11:04
 * @Describtion : 对象溢出
 */
@Slf4j
@ThreadUnSafe
public class Escape {

    private int thisCanBeEscape = 0 ;

    public Escape(){
        new InnerClass();
    }

    public class InnerClass {

        public InnerClass(){
            log.info("{}",Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }

}
