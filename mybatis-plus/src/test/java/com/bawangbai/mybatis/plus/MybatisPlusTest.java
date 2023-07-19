package com.bawangbai.mybatis.plus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bawangbai.mybatis.plus.account.mapper.UserMapper;
import com.bawangbai.mybatis.plus.account.pojo.UserDO;
import com.bawangbai.mybatis.plus.account.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MybatisPlusTest {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void test(){
//        List<UserDO> userDOS = userMapper.selectList(null);
//        userDOS.forEach(userDO -> System.out.println(userDO));
//    }
//
//    @Test
//    public void testDelete(){
////        userMapper.deleteByMap()
//    }
//
//    @Test
//    public void testCount(){
//        long count = userService.count();
//        log.info("testCount:{}",count);
//    }
//
//    @Test
//    public void testUpdate(){
////        userService.page()
//    }
//
//    @Test
//    public void testPage(){
//        Page<UserDO> page = new Page<>(1,2);
//        LambdaQueryWrapper<UserDO> wrapper = new LambdaQueryWrapper<>();
//        wrapper.ge(UserDO::getId,2);
//        Page<UserDO> page1 = userService.page(page, wrapper);
//
//    }

}
