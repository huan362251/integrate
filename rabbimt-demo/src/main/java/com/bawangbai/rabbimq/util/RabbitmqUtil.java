package com.bawangbai.rabbimq.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitmqUtil {

    public static Channel getChannel()  {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.56.108");
        factory.setUsername("admin");
        factory.setPassword("123");
        Connection connection = null;
        Channel channel = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return channel;
    }

}
