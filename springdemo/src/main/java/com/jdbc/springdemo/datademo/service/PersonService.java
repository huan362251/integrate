package com.jdbc.springdemo.datademo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jdbc.springdemo.datademo.entity.PersonDO;

public interface PersonService extends IService<PersonDO> {

    void test();

}
