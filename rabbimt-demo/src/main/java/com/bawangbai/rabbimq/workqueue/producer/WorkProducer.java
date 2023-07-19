package com.bawangbai.rabbimq.workqueue.producer;

import com.bawangbai.rabbimq.util.QueueName;
import com.bawangbai.rabbimq.util.RabbitmqUtil;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;

public class WorkProducer {

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitmqUtil.getChannel();
        for (int i = 0; i < 10; i++) {

            String msg = "hello rabbitmq" + i;
            channel.queueDeclare(QueueName.WORK_HELLO,false,false,false,null);

            channel.basicPublish("",QueueName.WORK_HELLO,null,msg.getBytes() );
            System.out.println("message already send");
        }
    }

}
