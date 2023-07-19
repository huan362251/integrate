package com.bawangbai.rabbimq.dead;

import com.bawangbai.rabbimq.util.RabbitmqUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.util.HashMap;

public class DeadConsumerTwo {

    public static final String DEAD_QUEUE = "dead_queue";
    public static final String DEAD_EXCHANGE = "dead_exchange";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitmqUtil.getChannel();
        channel.exchangeDeclare(DEAD_EXCHANGE, BuiltinExchangeType.DIRECT);
        //接收 消息
        DeliverCallback deliverCallback = (consumerTag, message) ->{
            System.out.println(new String(message.getBody()));
        };
        //异常中断
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println("消息异常："+consumerTag);
        };

        channel.basicConsume(DEAD_QUEUE,true,deliverCallback,cancelCallback);
        System.out.println("DirectConsumerOne receive message");

    }

}
