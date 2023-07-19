package com.example.shardsphere.jdbc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shardsphere.jdbc.entity.User;
import com.example.shardsphere.jdbc.mapper.UserMapper;
import com.example.shardsphere.jdbc.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  extends ServiceImpl<UserMapper, User> implements UserService {
}
