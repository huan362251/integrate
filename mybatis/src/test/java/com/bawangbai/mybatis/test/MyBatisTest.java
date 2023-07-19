package com.bawangbai.mybatis.test;

import com.bawangbai.mybatis.base.BaseTest;
import com.bawangbai.mybatis.mapper.UserMapper;
import com.bawangbai.mybatis.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Slf4j
public class MyBatisTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        userMapper.insertUser();
    }

    @Test
    public void testUpdate(){
        userMapper.updateUser();
    }

    @Test
    public void testDelete(){
        userMapper.deleteUser();
    }

    @Test
    public void queryById(){
        User user = userMapper.queryById();
        System.out.println(user);
    }

    @Test
    public void queryAllUser(){
        List<User> users = userMapper.queryAllUser();
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void queryByIds(){
        User user = userMapper.queryByIds(1);
        log.info("queryByIds result : {}",user);
    }

    @Test
    public void queryMap(){
        Map<String, Object> map = userMapper.queryResultMap();
        log.info("result:{}",map);
    }

    @Test
    public void queryTest(){
        List li = userMapper.queryLikeName("li");
        log.info("result:{}",li);
    }
}
