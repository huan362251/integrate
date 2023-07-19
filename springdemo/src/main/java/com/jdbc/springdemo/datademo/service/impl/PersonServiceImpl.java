package com.jdbc.springdemo.datademo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jdbc.springdemo.datademo.entity.PersonDO;
import com.jdbc.springdemo.datademo.mapper.PersonMapper;
import com.jdbc.springdemo.datademo.service.PersonService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, PersonDO> implements PersonService{

    @Override
    public void test() {
        PersonDO personDO = new PersonDO();
        personDO.setCurDate(LocalDate.now());
        personDO.setCurTime(LocalDateTime.now());
        System.out.println("person:"+personDO.toString());
        this.baseMapper.insert(personDO);
//        PersonDO personDO1 = this.baseMapper.selectOne(new LambdaQueryWrapper<PersonDO>().eq(PersonDO::getId, 1));
//        LocalDate currentDate = personDO1.getCurrentDate();
//        personDO1.setCurrentDate(currentDate);
//        personDO1.setId(2);
//        this.baseMapper.insert(personDO1);

    }
}
