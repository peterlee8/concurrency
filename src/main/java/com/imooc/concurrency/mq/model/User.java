package com.imooc.concurrency.mq.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author peterLee
 * @CreateDate 2019/3/22
 */
@Data
public class User implements Serializable {

    private Integer id;
    private String userName;
    private String name;

    public User(Integer id, String userName, String name) {
        this.id = id;
        this.userName = userName;
        this.name = name;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}