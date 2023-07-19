package com.bawangbai.mybatis.plus.account.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bawangbai.mybatis.plus.account.mapper.AmountMapper;
import com.bawangbai.mybatis.plus.account.mapper.UserMapper;
import com.bawangbai.mybatis.plus.account.pojo.AmountDO;
import com.bawangbai.mybatis.plus.account.pojo.UserDO;
import com.bawangbai.mybatis.plus.account.service.AmountService;
import com.bawangbai.mybatis.plus.account.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmountServiceImpl extends ServiceImpl<AmountMapper, AmountDO> implements AmountService {

}
