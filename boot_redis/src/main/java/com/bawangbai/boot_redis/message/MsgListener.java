package com.bawangbai.boot_redis.message;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
//import org.redisson.api.RSemaphore;
//import org.redisson.api.RedissonClient;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class MsgListener {

//    @Autowired
//    private RedissonClient redissonClient;

    @RabbitListener(queuesToDeclare = @Queue("pacypay.stl.task"),concurrency = "5-10")
    public void listenerQA(Message message, Channel channel) throws InterruptedException {
//        RSemaphore semlock = redissonClient.getSemaphore("semlock");
//        semlock.acquire();
//        String msg = new String(message.getBody());
//        log.info(" 当前时间：{}, 收到死信队列信息{}", LocalDateTime.now().toString(), msg);
//        semlock.release();
    }

}
