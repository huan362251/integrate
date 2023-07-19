package com.bawangbai.rabbimq.direct;

import com.bawangbai.rabbimq.util.RabbitmqUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

public class DirectConsumerTwo {

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitmqUtil.getChannel();
        channel.exchangeDeclare("direct", BuiltinExchangeType.DIRECT);
        channel.queueDeclare("console",false,false,false,null);
        channel.queueBind("console","direct","error");

        //接收 消息
        DeliverCallback deliverCallback = (consumerTag, message) ->{
            System.out.println(new String(message.getBody()));
        };
        //异常中断
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println("消息异常："+consumerTag);
        };

        channel.basicConsume("console",false,deliverCallback,cancelCallback);
        System.out.println("DirectConsumerTwo receive message");
    }

}
