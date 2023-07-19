package com.bawangbai.rabbimq.fanout;

import com.bawangbai.rabbimq.util.RabbitmqUtil;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

public class FanoutConsumerTwo {

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitmqUtil.getChannel();
        channel.exchangeDeclare("FANOUT", "fanout");
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue,"FANOUT","");

        //接收 消息
        DeliverCallback deliverCallback = (consumerTag, message) ->{
            System.out.println(new String(message.getBody()));
        };
        //异常中断
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println("消息异常："+consumerTag);
        };

        channel.basicConsume(queue,false,deliverCallback,cancelCallback);
        System.out.println("FanoutConsumerTwo receive message");

    }

}
