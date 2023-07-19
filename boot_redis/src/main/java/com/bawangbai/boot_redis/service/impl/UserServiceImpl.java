package com.bawangbai.boot_redis.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.bawangbai.boot_redis.entity.User;
import com.bawangbai.boot_redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public void test(){
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            User user = new User();
            user.setAge(i);
            user.setName("张三"+ i);
            list.add(user);
        }
        String s = JSON.toJSONString(list);
        redisTemplate.opsForValue().set("abc",s);
    }

    @Override
    public void getList(){
        Object abc = redisTemplate.opsForValue().get("abc");
        List<User> list = JSON.parseObject(abc.toString(), new TypeReference<List<User>>() {
        });
        for (User user : list) {
            System.out.println(user);
        }
    }
}
