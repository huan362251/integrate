package com.bawangbai.rabbimq.dead;

import com.bawangbai.rabbimq.util.RabbitmqUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.util.HashMap;

public class DeadConsumerOne {

    public static final String DEAD_EXCHANGE = "dead_exchange";

    public static final String DEAD_QUEUE = "dead_queue";

    public static final String NORMAL_EXCHANGE = "normal_exchange";

    public static final String NORMAL_QUEUE = "normal_queue";


    public static void main(String[] args) throws Exception {
        Channel channel = RabbitmqUtil.getChannel();
        channel.exchangeDeclare(NORMAL_EXCHANGE, BuiltinExchangeType.DIRECT);
        channel.exchangeDeclare(DEAD_EXCHANGE, BuiltinExchangeType.DIRECT);
        //配置死信后转到死信队列的信息，并将死信的消息转过去
        HashMap<String, Object> arg = new HashMap<>();
//        arg.put("x-message-ttl",10000);
        arg.put("x-dead-letter-exchange",DEAD_EXCHANGE);
        arg.put("x-dead-letter-routing-key","lisi");
//        arg.put("x-max-length",6);
        //绑定队列
        channel.queueDeclare(NORMAL_QUEUE,false,false,false,arg);
        channel.queueBind(NORMAL_QUEUE,NORMAL_EXCHANGE,"zhangsan");

        channel.queueDeclare(DEAD_QUEUE,false,false,false,null);
        channel.queueBind(DEAD_QUEUE,DEAD_EXCHANGE,"lisi");
        //接收 消息
        DeliverCallback deliverCallback = (consumerTag, message) ->{
            System.out.println(new String(message.getBody()));
            String value = new String(message.getBody(), "UTF8");
            if(value.equals("5")){
                System.out.println("拒绝消息：" + value);
                channel.basicReject(message.getEnvelope().getDeliveryTag(),false);
            }else {
                channel.basicAck(message.getEnvelope().getDeliveryTag(),false);
            }
        };
        //异常中断
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println("消息异常："+consumerTag);
        };

        channel.basicConsume(NORMAL_QUEUE,false,deliverCallback,cancelCallback);
        System.out.println("DirectConsumerOne receive message");

    }

}
