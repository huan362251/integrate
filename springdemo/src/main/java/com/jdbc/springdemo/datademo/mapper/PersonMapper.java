package com.jdbc.springdemo.datademo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jdbc.springdemo.datademo.entity.PersonDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper extends BaseMapper<PersonDO> {


}
