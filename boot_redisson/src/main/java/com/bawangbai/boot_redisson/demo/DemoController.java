package com.bawangbai.boot_redisson.demo;

import com.bawangbai.util.RedissonUtil;
import org.redisson.client.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private RedissonUtil redissonUtil;

    @GetMapping("test")
    public void test(){
        redissonUtil.lock("abc");
        redissonUtil.unlock("bac");
    }
}
