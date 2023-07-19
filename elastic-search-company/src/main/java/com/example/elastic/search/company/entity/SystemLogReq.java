package com.example.elastic.search.company.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SystemLogReq implements Serializable {


    private static final long serialVersionUID = 7293987834007995921L;

    /**
     * 交易流水号 v3
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
     * 原交易流水号 v3
     */
    private String oriServiceId;

    /**
     * 日志生成时间
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime beginTime;

    /**
     * 日志结束时间
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endTime;

    /**
     * 店铺原始地址
     */
    private String shop;

    /**
     * 支付Id
     */
    private String paymentID;

}
