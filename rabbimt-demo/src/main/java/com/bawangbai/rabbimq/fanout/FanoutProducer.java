package com.bawangbai.rabbimq.fanout;

import com.bawangbai.rabbimq.util.RabbitmqUtil;
import com.rabbitmq.client.Channel;

public class FanoutProducer {

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitmqUtil.getChannel();

        for (int i = 0; i < 100; i++) {
            channel.basicPublish("FANOUT", "",null,(i+"").getBytes() );
        }


    }

}
