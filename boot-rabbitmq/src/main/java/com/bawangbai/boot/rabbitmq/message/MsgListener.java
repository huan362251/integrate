package com.bawangbai.boot.rabbitmq.message;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.example.TestEntity;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class MsgListener {

    public static final String QUEUE_A = "QA";

    public static final String QUEUE_B = "QB";

    public static final String QUEUE_D = "QD";

//    @RabbitListener(queuesToDeclare = @Queue(value = "test"))
//    public void test(TestEntity test) throws InterruptedException {
//        log.info("接收消息:{}",test);
//        log.info("处理完成:{}",test.getName());
//    }

    @RabbitListener(queues = "QD")
    public void listenerQA(Message message, Channel channel){
        String msg = new String(message.getBody());
        log.info(" 当前时间：{}, 收到死信队列信息{}", LocalDateTime.now().toString(), msg);
    }

    @RabbitListener(queues = "delayed.queue")
    public void listenerDelayed(Message message){
        String msg = new String(message.getBody());
        log.info("延迟队列接收 消息， 当前时间：{}, 收到死信队列信息{}", LocalDateTime.now().toString(), msg);
    }

    @RabbitListener(queues = "confirm.queue")
    public void listenerConfirm(Message message){
        String msg = new String(message.getBody());
        log.info("队列接收消息,当前时间：{}, 收到死信队列信息{}", LocalDateTime.now().toString(), msg);
    }

    @RabbitListener(queues = "queue.backup")
    public void listenerBackupQueue(Message message){
        String msg = new String(message.getBody());
        log.info("备份队列接收消息,当前时间：{}, 收到备份队列信息{}", LocalDateTime.now().toString(), msg);
    }

    @RabbitListener(queues = "warning.backup")
    public void listenerWarningQueue(Message message){
        String msg = new String(message.getBody());
        log.info("报警队列接收消息,当前时间：{}, 收到报警队列信息{}", LocalDateTime.now().toString(), msg);
    }

}
