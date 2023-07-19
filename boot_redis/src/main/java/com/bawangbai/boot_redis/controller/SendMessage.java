package com.bawangbai.boot_redis.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("send")
public class SendMessage {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("sendMsg")
    public void sendGeneralMsg(){
        System.out.println("sendGeneralMsg begin");
        for (int i = 0; i < 1000; i++) {
            rabbitTemplate.convertAndSend("pacypay.stl.task","haha" + i);
        }
        System.out.println("sendGeneralMsg end");
    }
}
