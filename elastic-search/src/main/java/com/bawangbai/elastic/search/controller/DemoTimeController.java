package com.bawangbai.elastic.search.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("generate")
public class DemoTimeController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("test")
    public void test(){
        rabbitTemplate.convertAndSend("demo.listener","hello demo");
    }

}
