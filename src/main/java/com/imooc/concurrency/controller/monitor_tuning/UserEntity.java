package com.imooc.concurrency.controller.monitor_tuning;

import lombok.Data;

/**
 * @Author peterLee
 * @Date 2018/9/11 上午10:45
 * @Describtion :
 */
@Data
public class UserEntity {
    private int id;
    private String name;

    public UserEntity(int id,String name){
        this.id =id;
        this.name =name;
    }
}
