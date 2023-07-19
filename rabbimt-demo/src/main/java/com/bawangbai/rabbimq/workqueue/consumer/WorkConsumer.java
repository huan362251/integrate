package com.bawangbai.rabbimq.workqueue.consumer;

import com.bawangbai.rabbimq.util.QueueName;
import com.bawangbai.rabbimq.util.RabbitmqUtil;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class WorkConsumer {

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

        System.out.println("c2 接收消息");

        channel.basicConsume(QueueName.WORK_HELLO,true,deliverCallback,cancelCallback);
    }


}
