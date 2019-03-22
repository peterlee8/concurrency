package com.imooc.concurrency.mq.producer;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author peterLee
 * @CreateDate 2019/3/22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitMqSenderTest {

    @Autowired
    RabbitSender rabbitMqSender;

    @Test
    public void send() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name","1");
        map.put("age","1");
        rabbitMqSender.send("Springboot.hello", JSON.toJSONString(map));
    }

}