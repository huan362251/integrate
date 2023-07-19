package com.bawangbai.mybatis.plus.account.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("spt_amount")
public class AmountDO {

    @TableId
    private Long id;

    private BigDecimal beforeAmount;

    private BigDecimal afterAmount;

    private BigDecimal amount;

}
