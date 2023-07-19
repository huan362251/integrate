package com.bawangbai.mybatis.plus.account.controller;

import com.bawangbai.mybatis.plus.account.pojo.UserDO;
import com.bawangbai.mybatis.plus.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public void test(){
        long start = System.currentTimeMillis();
        userService.saveUser();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @GetMapping("/queryOne")
    public UserDO queryOne(@RequestParam(value = "age") int age){
        long start = System.currentTimeMillis();
        UserDO userDO = userService.queryOne(age);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return userDO;
    }

}
