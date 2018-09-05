package com.imooc.concurrency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author peterlee
 * @Date 2018/9/5 上午10:37
 * @Describtion :
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/put")
    public String set(@RequestParam("key")String key,
                      @RequestParam("value") String value){
        redisTemplate.opsForValue().set(key,value);
        return null;
    }

    @GetMapping("/get")
    public String get(@RequestParam("key")String key){
        return redisTemplate.opsForValue().get(key);
    }
}
