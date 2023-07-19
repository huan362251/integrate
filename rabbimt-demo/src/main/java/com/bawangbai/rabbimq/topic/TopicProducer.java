package com.bawangbai.rabbimq.topic;

import com.bawangbai.rabbimq.util.RabbitmqUtil;
import com.rabbitmq.client.Channel;

import java.util.Random;
import java.util.UUID;

public class TopicProducer {

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitmqUtil.getChannel();

//        for (int i = 0; i < 30; i++) {
//            if (i < 10) {
//                String a = UUID.randomUUID().toString() + ".orange." + i;
//                channel.basicPublish("topic", "a", null, a.getBytes());
//                System.out.println("message :" + a);
//            } else if (i < 20) {
//                String a = UUID.randomUUID().toString() + "." + i + ".rabbit";
//                channel.basicPublish("topic", "a", null, a.getBytes());
//                System.out.println("message :" + a);
//            } else {
//                String a = "lazy." + UUID.randomUUID().toString() + "." + i ;
//                channel.basicPublish("topic", "a", null, a.getBytes());
//                System.out.println("message :" + a);
//            }
//        }

        channel.basicPublish("topic", "a.orange.test", null, "hehe1".getBytes());
        channel.basicPublish("topic", "a.test.rabbit", null, "haha2".getBytes());
        channel.basicPublish("topic", "lazy.a.b", null, "heihei3".getBytes());

    }

}
