package com.bawangbai.apollo_quick.user.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Value("${sms.enable}")
    private String value;

    @Value("${a}")
    private String mqValue;

    @Value("${redis.value}")
    private String redisValue;

    @Value("${order.id}")
    private String orderId;

    @GetMapping("test")
    public void test() throws InterruptedException {
        Config appConfig = ConfigService.getAppConfig();
        String property = appConfig.getProperty("sms.enable", null);
        log.info("test sms enable:{}", property);
        log.info("test sms value:{}",value);
        log.info("test a value:{}",mqValue);
        log.info("redis values:{}",redisValue);
        log.info("order.id:{}",orderId);
    }
}
