package com.bawangbai.mybatis.plus.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bawangbai.mybatis.plus.account.pojo.UserDO;

public interface UserService extends IService<UserDO> {

    public void saveUser();

    UserDO queryOne(int age);
}
