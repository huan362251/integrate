package com.example.elastic.search.company.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SystemLogSaveReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户订单号
     */
    private String merchantOrderNumber;

    /**
     * 商户号
     */
    private Long merchantNo;

    /**
     * 原交易流水号 v3
     */
    private Long oriServiceId;

    /**
     * 日志生成时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime generateTime;

    /**
     * 详情
     */
    private String details;

    /**
     * 线程号
     */
    private String threadId;

    /**
     * 店铺原始地址
     */
    private String shop;

    /**
     * 支付Id
     */
    private String paymentID;

    private String sourceValue;
    /**
     * v1系统交易流水号
     */
    private String v1ServiceId;

    /**
     * 功能描述
     */
    private String functionalDescription;

    /**
     * 系统来源-字符串值
     */
    private String systemSourceValue;

}
