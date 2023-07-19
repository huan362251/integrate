package com.bawangbai.rabbimq.topic;

import com.bawangbai.rabbimq.util.RabbitmqUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

public class TopicConsumerOne {

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitmqUtil.getChannel();
        channel.exchangeDeclare("topic", BuiltinExchangeType.TOPIC);
        channel.queueDeclare("q1",false,false,false,null);

        channel.queueBind("q1","topic","*.orange.*");

        //接收 消息
        DeliverCallback deliverCallback = (consumerTag, message) ->{
            System.out.println("q1 receive message:"+new String(message.getBody()));
        };
        //异常中断
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println("消息异常："+consumerTag);
        };

        channel.basicConsume("q1",false,deliverCallback,cancelCallback);
        System.out.println("TopicConsumerOne receive message");

    }

}
