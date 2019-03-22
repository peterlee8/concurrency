package com.imooc.concurrency.mq.producer;


import java.util.Map;
import java.util.UUID;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author peterLee
 * @CreateDate 2019/3/22
 */
@Component
public class RabbitSender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final String EXCHANGE = "exchange-1";

    /**
     * 发送消息
     * @param routingKey 路由号码
     * @param jsonString
     */
    public void send(String routingKey, String jsonString) {
        rabbitTemplate.setConfirmCallback(this);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());//唯一标识

        System.out.println("发送消息id:" + correlationData.getId());
        // 用RabbitMQ发送MQTT需将exchange配置为amq.topic
        this.rabbitTemplate.convertAndSend(EXCHANGE, routingKey, jsonString, correlationData);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("确认消息id:" + correlationData.getId());
        if (ack) {
            System.out.println("消息发送确认成功");
        } else {
            //处理异常
            System.out.println("消息发送确认失败,需要处理异常:" + cause);
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("return--message:" + new String(message.getBody()) + ",replyCode:" + replyCode
                + ",replyText:" + replyText + ",exchange:" + exchange + ",routingKey:" + routingKey);
    }

    /**
     *
     * 如果消息没有到exchange,则confirm回调,ack=false

     如果消息到达exchange,则confirm回调,ack=true

     exchange到queue成功,则不回调return

     exchange到queue失败,则回调return(需设置mandatory=true,否则不回回调,消息就丢了)

     */
}
