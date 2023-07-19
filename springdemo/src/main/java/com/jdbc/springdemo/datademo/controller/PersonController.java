package com.jdbc.springdemo.datademo.controller;

import com.jdbc.springdemo.datademo.config.CheckConfig;
import com.jdbc.springdemo.datademo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private CheckConfig checkConfig;

    @Autowired
    private PersonService personService;

    @GetMapping("/test")
    public void test(){
        personService.test();
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/test1")
    public void test1(){
        redisTemplate.opsForValue().set("a","b");
    }

    @GetMapping("/test2")
    public void test2(){
        System.out.println(checkConfig.getId());
    }

}
