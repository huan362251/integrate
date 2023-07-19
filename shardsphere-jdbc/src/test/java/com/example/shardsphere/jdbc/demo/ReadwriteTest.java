package com.example.shardsphere.jdbc.demo;

import com.example.shardsphere.jdbc.entity.User;
import com.example.shardsphere.jdbc.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class ReadwriteTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 写入数据的测试
     */
    @Test
    public void testInsert(){

        User user = new User();
        user.setUname("张三丰");
        userMapper.insert(user);
    }

    @Transactional//开启事务
    @Test
    public void testTrans(){

        User user = new User();
        user.setUname("铁锤");
        userMapper.insert(user);

        List<User> users = userMapper.selectList(null);
    }

    @Test
    public void testTransOne(){

        User user = new User();
        user.setUname("铁锤");
        userMapper.insert(user);

        List<User> users = userMapper.selectList(null);
    }

    @Test
    public void testSelectAll(){
        List<User> users = userMapper.selectList(null);
        users = userMapper.selectList(null);//执行第二次测试负载均衡
        users.forEach(System.out::println);
    }

}
