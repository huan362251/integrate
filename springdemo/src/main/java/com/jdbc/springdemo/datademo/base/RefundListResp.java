package com.jdbc.springdemo.datademo.base;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RefundListResp {

    /**
     * 交易流水号
     */
    private Long txnId;

    /**
     * 退款金额
     */
    private BigDecimal refundAmount;

    /**
     * 错误信息
     */
    private String errorMessage;

}
