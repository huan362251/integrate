package com.bawangbai.mybatis.plus.account.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bawangbai.mybatis.plus.account.pojo.AccountTxnDO;
import com.bawangbai.mybatis.plus.account.mapper.AccountTxnMapper;
import com.bawangbai.mybatis.plus.account.service.AccountTxnService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class AccountTxnServiceImpl extends ServiceImpl<AccountTxnMapper, AccountTxnDO> implements AccountTxnService {
    public void updateStatus(){
        AccountTxnDO accountTxnDO = new AccountTxnDO();
        this.baseMapper.update(null,new LambdaUpdateWrapper<AccountTxnDO>()
                .set(ObjectUtil.isNotEmpty(accountTxnDO.getAcntTxnDate()),AccountTxnDO::getAcntTxnDate,accountTxnDO.getAcntTxnDate())
                .set(StringUtils.isNotBlank(accountTxnDO.getStatus()),AccountTxnDO::getStatus,accountTxnDO.getStatus())
                .eq(AccountTxnDO::getAcntTxnId,accountTxnDO.getAcntTxnId())
        );
    }
}
