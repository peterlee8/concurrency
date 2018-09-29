package com.imooc.concurrency.controller.monitor_tuning;

import com.imooc.concurrency.controller.monitor_tuning.meta.Metaspace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author peterLee
 * @Date 2018/9/11 上午10:43
 * @Describtion : 内存监控
 */
@RestController
public class MemoryController {

    private List<UserEntity> userEntityList =new ArrayList<>();
    private List<Class<?>> classList =new ArrayList<>();

    /**
     * -Xmx32M -Xms32M
     * @return
     */
    @GetMapping("/heap")
    public String heap(){
        int i =0;
        while (true){
            userEntityList.add(new UserEntity(i++,UUID.randomUUID().toString()));
        }
    }

    /**
     * -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
     * @return
     */
    @GetMapping("/nonheap")
    public String  nonheap(){
        while (true){
            classList.addAll(Metaspace.createClasses());
        }
    }

}
