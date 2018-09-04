package com.imooc.concurrency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author peterlee
 * @Date 2018/9/3 下午4:29
 * @Describtion :
 */
@RestController
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    @GetMapping("/index")
    public String test(){
        return "success";
    }
}
