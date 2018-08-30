package com.imooc.concurrency.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author peterlee
 * @Date 2018/8/28 下午9:13
 * @Describtion :
 */
@RestController
@Slf4j
public class TestController {

    @GetMapping("/test")
    public String test(){
        log.info("test");
        return "test";
    }

}
