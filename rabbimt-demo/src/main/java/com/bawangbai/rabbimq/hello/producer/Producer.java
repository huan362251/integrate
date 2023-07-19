package com.bawangbai.rabbimq.hello.producer;

import com.bawangbai.rabbimq.util.QueueName;
import com.bawangbai.rabbimq.util.RabbitmqUtil;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitmqUtil.getChannel();
        String msg = "hello rabbitmq";
        channel.queueDeclare(QueueName.QUEUE_HELLO,false,false,false,null);

        channel.basicPublish("",QueueName.QUEUE_HELLO,null,msg.getBytes() );
        System.out.println("message already send");
        channel.close();
    }

}
