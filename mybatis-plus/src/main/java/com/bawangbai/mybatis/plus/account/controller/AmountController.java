package com.bawangbai.mybatis.plus.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.bawangbai.mybatis.plus.account.pojo.AmountDO;
import com.bawangbai.mybatis.plus.account.service.AmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/amount")
public class AmountController {

    @Autowired
    private AmountService amountService;

    @GetMapping("save")
    public void save(){
        List<AmountDO> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            AmountDO amountDO = new AmountDO();
            amountDO.setId(Long.valueOf(i));
            amountDO.setAfterAmount(new BigDecimal(String.valueOf(i)));
            amountDO.setAmount(new BigDecimal(String.valueOf(i)));
            if (i % 10 ==0){
                amountDO.setBeforeAmount(new BigDecimal(String.valueOf(i)).add(new BigDecimal(String.valueOf(i))));
            } else {
                amountDO.setBeforeAmount(new BigDecimal(String.valueOf(i)).subtract(new BigDecimal(String.valueOf(i))));
            }
            list.add(amountDO);
        }
        amountService.saveBatch(list);
    }


    @GetMapping("updateOneTwoAmount")
    @Transactional
    public void updateOneTwoAmount(){
        for (int i = 0; i < 100000; i++) {
            List<AmountDO> list = amountService.list(new LambdaQueryWrapper<AmountDO>().in(AmountDO::getId, Arrays.asList(1L, 2L)));
            for (AmountDO amountDO : list) {
                BigDecimal amount = amountDO.getAmount();
                BigDecimal beforeAdd = amountDO.getBeforeAmount().add(amount);
                BigDecimal afterAdd = amountDO.getAfterAmount().add(amount);
                amountService.update(new LambdaUpdateWrapper<AmountDO>()
                        .set(AmountDO::getBeforeAmount, beforeAdd)
                        .set(AmountDO::getAfterAmount, afterAdd)
                        .eq(AmountDO::getId, amountDO.getId()));
            }
        }
    }

    @GetMapping("updateOneThreeAmount")
    @Transactional
    public void updateOneThreeAmount(){
        for (int i = 0; i < 100000; i++) {
            List<AmountDO> list = amountService.list(new LambdaQueryWrapper<AmountDO>().in(AmountDO::getId, Arrays.asList(1L, 3L)));
            for (AmountDO amountDO : list) {
                BigDecimal amount = amountDO.getAmount();
                BigDecimal beforeAdd = amountDO.getBeforeAmount().add(amount);
                BigDecimal afterAdd = amountDO.getAfterAmount().add(amount);
                amountService.update(new LambdaUpdateWrapper<AmountDO>()
                        .set(AmountDO::getBeforeAmount,beforeAdd)
                        .set(AmountDO::getAfterAmount,afterAdd)
                        .eq(AmountDO::getId,amountDO.getId()));
            }
        }

    }

}
