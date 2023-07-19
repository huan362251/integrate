package com.jdbc.springdemo.datademo.base;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RefundInfoDTO {

    /**
     * 交易流水号
     */
    private Long txnId;

    /**
     * 退款金额
     */
    private BigDecimal refundAmount;

}

