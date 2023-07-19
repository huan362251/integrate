package com.example.elastic.search.company.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SystemLog {

    /**
     * 商品ID
     */
    private Long id;

    /**
     * 交易流水号
     */
    private String serviceId;

    /**
     * 商户订单号
     */
    private String merchantOrderNumber;

    /**
     * 线程号
     */
    private String threadId;

    /**
     * 商户号
     */
    private Long merchantNo;

    /**
     * 原交易流水号
     */
    private String oriServiceId;

    /**
     * 日志生成时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss:SSS")
    private LocalDateTime generateTime;

    /**
     * 详情
     */
    private String details;

    /**
     * 请求id
     */
    private Long requestId;

    /**
     * 系统来源
     */
    private String systemSource;

    /**
     * 店铺原始地址
     */
    private String shop;

    /**
     * 支付Id
     */
    private String paymentID;

    /**
     * 功能描述
     */
    private String functionalDescription;

}
