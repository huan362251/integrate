package com.bawangbai.boot.rabbitmq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("thread")
public class ThreadController {

    @GetMapping("test")
    public void test(){

    }


}
