package com.bawangbai.rabbimq.hello.consumer;

import com.bawangbai.rabbimq.util.QueueName;
import com.bawangbai.rabbimq.util.RabbitmqUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitmqUtil.getChannel();

        //接收 消息
        DeliverCallback deliverCallback = (consumerTag, message) ->{
            System.out.println(new String(message.getBody()));
        };
        //异常中断
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println("消息异常："+consumerTag);
        };

        channel.basicConsume(QueueName.QUEUE_HELLO,true,deliverCallback,cancelCallback);
    }


}
