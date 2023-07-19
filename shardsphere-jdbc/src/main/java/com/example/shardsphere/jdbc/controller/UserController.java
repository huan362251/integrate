package com.example.shardsphere.jdbc.controller;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.shardsphere.jdbc.entity.User;
import com.example.shardsphere.jdbc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("test")
    public void test(){
        List<User> list = userService.list();
        for (User user : list) {
            log.info("user id:{},name:{}",user.getId(),user.getUname());
        }
    }

    @GetMapping("testDemo")
    public void testDemo(){
        userService.list(new LambdaQueryWrapper<User>()
                .eq(User::getUname,"赵七")
        );
    }

    @GetMapping("queryPoint")
    public void queryPoint(){
        log.info("begin 1");
        User one = userService.getOne(new LambdaUpdateWrapper<User>().eq(User::getId, 1));
        log.info("end one id:{},name:{}",one.getId(),one.getUname());
        User one1 = userService.getOne(new LambdaUpdateWrapper<User>().eq(User::getId, 2));
        log.info("end one1 id:{},name:{}",one1.getId(),one1.getUname());
        User one2 = userService.getOne(new LambdaUpdateWrapper<User>().eq(User::getId, 3));
        log.info("end one2 id:{},name:{}",one2.getId(),one2.getUname());
        User one3 = userService.getOne(new LambdaUpdateWrapper<User>().eq(User::getId, 4));
        log.info("end one3 id:{},name:{}",one3.getId(),one3.getUname());
        User one4 = userService.getOne(new LambdaUpdateWrapper<User>().eq(User::getId, 5));
        log.info("end one4 id:{},name:{}",one4.getId(),one4.getUname());
        User one5 = userService.getOne(new LambdaUpdateWrapper<User>().eq(User::getId, 6));
        log.info("end one5 id:{},name:{}",one5.getId(),one5.getUname());
    }

    @GetMapping("save")
    public void save(){
        for (int i = 0; i < 10000; i++) {
            User user = new User();
            long l = IdUtil.getSnowflake(1,2).nextId();
            if(l%2!=0){
                log.info("奇数:{}",l);
            }
            user.setId(Long.valueOf(i));
            user.setUname("赵七");
            userService.save(user);
        }

    }


}
