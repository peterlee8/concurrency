package com.imooc.concurrency.controller;

import com.imooc.concurrency.controller.base.BaseController;
import com.imooc.concurrency.util.PageData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @Author peterLee
 * @Date 2018/9/5 下午3:27
 * @Describtion :
 */
@RestController
@RequestMapping
@Slf4j
public class IndexController extends BaseController {

    @GetMapping("/index")
    public String index(){
        PageData pageData = this.getPageData();
        log.info("---->index");
        return "webApp/index";
    }

    @PostMapping (value="/index")
    public String index2() throws IOException {
        PageData pageData = this.getPageData();
        log.info("---->index");
        return "webApp/index";
    }



}
