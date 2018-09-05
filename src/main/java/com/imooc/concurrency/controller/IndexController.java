package com.imooc.concurrency.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author peterLee
 * @Date 2018/9/5 下午3:27
 * @Describtion :
 */
@Controller
@RequestMapping
@Slf4j
public class IndexController {

    @GetMapping("/index")
    public String index(){
        log.info("---->index");
        return "webApp/index";
    }

}
