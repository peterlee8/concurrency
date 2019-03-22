package com.imooc.concurrency.mq.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.concurrency.ConcurrencyApplication;
import com.imooc.concurrency.mq.model.User;
import com.imooc.concurrency.mq.producer.RabbitSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author peterLee
 * @CreateDate 2019/3/22
 */
@RestController
public class RabbitController {

    private static final Logger log= LoggerFactory.getLogger(ConcurrencyApplication.class);

    private static final String Prefix="rabbit";

    @Autowired
    private RabbitSender rabbitSender;

    /**
     * 发送对象消息
     * @param user
     * @return
     */
    @PostMapping(value = Prefix+"/object/message/send")
    public User sendObjectMessage(@RequestBody User user){
        try {
            log.info("待发送的消息： {} ",user);
            rabbitSender.send("spring.test", JSON.toJSONString(user));
        }catch (Exception e){
            log.error("发送对象消息发生异常： ",e.fillInStackTrace());
        }
        return user;
    }




}



