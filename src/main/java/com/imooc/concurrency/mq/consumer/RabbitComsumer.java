package com.imooc.concurrency.mq.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author peterLee
 * @CreateDate 2019/3/22
 */
@Component
public class RabbitComsumer {


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue-1",durable = "true"),
            exchange = @Exchange(value = "exchange-1",durable = "true",type = "topic",ignoreDeclarationExceptions = "true"),
            key = "spring.*"
                     )
                )
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception{
        System.out.println("------------------------------------");
        System.out.println("【消费端payload】:"+message.getPayload());

        Long deliveryTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        //手工ACK
        channel.basicAck(deliveryTag,false);
    }
}
