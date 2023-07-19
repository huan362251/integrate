package com.bawangbai.mybatis.controller;

import com.bawangbai.mybatis.mapper.UserMapper;
import com.bawangbai.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public void test(){
        userService.insertUser();
    }
}
