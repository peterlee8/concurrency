package com.imooc.concurrency.example.publish;

import com.imooc.concurrency.annotations.ThreadUnSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author peterlee
 * @Date 2018/8/31 上午10:59
 * @Describtion : 发布对象时，线程私有属性被调用，线程非安全
 */
@ThreadUnSafe
@Slf4j
public class UnSafePublish {

    private String[] status ={"a","b","c"};

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }

    public static void main(String[] args) {
        UnSafePublish publish =new UnSafePublish();
        log.info("{}",Arrays.toString(publish.getStatus()));

        publish.getStatus()[0] = "d";
        log.info("{}",Arrays.toString(publish.getStatus()));
    }
}
