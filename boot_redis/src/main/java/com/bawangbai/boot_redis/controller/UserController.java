package com.bawangbai.boot_redis.controller;

import com.bawangbai.boot_redis.config.RedisUtil;
import com.bawangbai.boot_redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("test")
    public void test(){
        userService.test();
    }

    @GetMapping("getList")
    public void getList(){
        userService.getList();
    }

    @Autowired
    private RedisUtil redisUtil;
    @GetMapping("testMap")
    public void testMap(){
        redisUtil.hmset("limit:consum","aaa","1");
        redisUtil.hmset("limit:consum","bbb","2");
        redisUtil.hmset("limit:consum","ccc","3");
        redisUtil.hmset("limit:consum","ddd","4");
    }

    @GetMapping("delMap")
    public void delMap(){
        redisUtil.hmdel("limit:consum","aaa");
        redisUtil.hmdel("limit:consum","bbb");
    }

}
