package com.bawangbai.rabbimq.dead;

import com.bawangbai.rabbimq.util.RabbitmqUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

public class DeadProduct {

    public static final String NORMAL_EXCHANGE = "normal_exchange";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitmqUtil.getChannel();
//        AMQP.BasicProperties props = new AMQP.BasicProperties().builder().expiration("10000").build();
        for (int i = 0; i < 10; i++) {
            channel.basicPublish(NORMAL_EXCHANGE, "zhangsan", null, (i + "").getBytes());
        }

        System.out.println("DirectConsumerOne receive message");
    }

}
