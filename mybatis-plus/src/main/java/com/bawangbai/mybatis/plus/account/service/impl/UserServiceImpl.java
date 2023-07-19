package com.bawangbai.mybatis.plus.account.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bawangbai.mybatis.plus.account.mapper.UserMapper;
import com.bawangbai.mybatis.plus.account.pojo.UserDO;
import com.bawangbai.mybatis.plus.account.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Override
    @Transactional(readOnly = true,timeout = 3,propagation = Propagation.NESTED)
    public void saveUser() {
        Snowflake snowflake = new Snowflake(1, 1);
        List<UserDO> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            UserDO userDO = new UserDO();
            userDO.setAge(i);
            userDO.setEmail(i + "@qq.com");
            userDO.setName("张三" + i);
            userDO.setId(snowflake.nextId());
            list.add(userDO);
            if (list.size() % 10 == 0) {
                this.saveBatch(list);
                list.clear();
            }
        }
        if (list.size() != 0) {
            this.saveBatch(list);
        }
    }

    @Override
    public UserDO queryOne(int age) {
        return this.baseMapper.selectList(new LambdaQueryWrapper<UserDO>().eq(UserDO::getAge,age)).get(0);
    }
}
