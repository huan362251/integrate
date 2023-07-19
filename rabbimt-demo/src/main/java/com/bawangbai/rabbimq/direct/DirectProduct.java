package com.bawangbai.rabbimq.direct;

import com.bawangbai.rabbimq.util.QueueName;
import com.bawangbai.rabbimq.util.RabbitmqUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

public class DirectProduct {

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitmqUtil.getChannel();

        for (int i = 0; i < 10; i++) {
            if(i>5) {
                channel.basicPublish("direct", "info", null, (i + "").getBytes());
            }else {
                channel.basicPublish("direct", "error", null, (i + "").getBytes());
            }
        }

        System.out.println("DirectConsumerOne receive message");

    }

}
