package com.bawangbai.mybatis.service.impl;

import com.bawangbai.mybatis.mapper.UserMapper;
import com.bawangbai.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser() {
        userMapper.insertUser();
    }

}
