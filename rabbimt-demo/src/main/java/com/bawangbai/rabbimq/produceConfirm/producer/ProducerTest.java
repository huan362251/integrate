package com.bawangbai.rabbimq.produceConfirm.producer;

import com.bawangbai.rabbimq.hello.producer.Producer;
import com.bawangbai.rabbimq.util.QueueName;
import com.bawangbai.rabbimq.util.RabbitmqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ProducerTest {

    public static final Integer SEND_COUNT = 10000;

    public static void main(String[] args) throws Exception {
        ProducerTest.singSend();
        ProducerTest.batchSend();
        ProducerTest.asyncSend();
    }


    //单个发送 单条耗时：1986ms
    public static void singSend() throws IOException, TimeoutException, InterruptedException {
        Channel channel = RabbitmqUtil.getChannel();
        channel.confirmSelect();
        channel.queueDeclare(QueueName.SING_QUEUE,true,false,false,null);

        long begin = System.currentTimeMillis();
        for (Integer i = 0; i < SEND_COUNT; i++) {
            channel.basicPublish("", QueueName.SING_QUEUE,null,(i+"").getBytes());
            channel.waitForConfirms();
        }
        long end = System.currentTimeMillis();
        System.out.println("单条耗时：" + (end - begin) + "ms");
    }


    //批量发送 批次耗时：506ms
    public static void batchSend() throws Exception{
        Channel channel = RabbitmqUtil.getChannel();
        channel.confirmSelect();
        channel.queueDeclare(QueueName.BATCH_QUEUE,true,false,false,null);

        long begin = System.currentTimeMillis();
        for (Integer i = 0; i < SEND_COUNT; i++) {
            channel.basicPublish("", QueueName.BATCH_QUEUE,null,(i+"").getBytes());
        }
        channel.waitForConfirms();
        long end = System.currentTimeMillis();
        System.out.println("批次耗时：" + (end - begin) + "ms");
    }


    //异步发送 异步耗时：189ms
    public static void asyncSend()throws Exception{
        Channel channel = RabbitmqUtil.getChannel();
        channel.confirmSelect();
        channel.queueDeclare(QueueName.ASYNC_QUEUE,true,false,false,null);

        ConfirmCallback ackCallback = (long deliveryTag, boolean multiple) -> {
//            System.out.println("确认消费消息："+ deliveryTag);
        } ;
        ConfirmCallback nackCallback = (long deliveryTag, boolean multiple) -> {
//            System.out.println("确认未消费消息："+ deliveryTag);
        } ;

        channel.addConfirmListener(ackCallback,nackCallback);

        long begin = System.currentTimeMillis();
        for (Integer i = 0; i < SEND_COUNT; i++) {
            channel.basicPublish("", QueueName.ASYNC_QUEUE,null,(i+"").getBytes());
        }
        long end = System.currentTimeMillis();
        System.out.println("异步耗时：" + (end - begin) + "ms");
    }

}
