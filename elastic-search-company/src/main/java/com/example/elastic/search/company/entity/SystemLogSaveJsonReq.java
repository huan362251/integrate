package com.example.elastic.search.company.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SystemLogSaveJsonReq implements Serializable {

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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
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

    /**
     * 日志来源
     * shopify交易日志需要补充，历史日志无需变更
     */
    private String source;

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
    private String systemSource;

    private String requestType;
    /**
     * uniqueId of request
     */
    private Long requestId;

    /**
     * the traceId
     */

    private String traceId;

    /**
     * serviceID among two systems
     */

    private Long serviceId;

    /**
     * serviceType match serviceId system
     */

    private String serviceType;

}
