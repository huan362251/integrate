package com.example.elastic.search8.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class OperationLogQueryReq  {

    /**
     * 标记 merchant-商户端  operation-运营端
     */
    private String owSource;

    /**
     * 操作开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime generateTimeBegin;

    /**
     * 操作结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime generateTimeEnd;

    /**
     * 商户号
     */
    private Long merchantNo;

    /**
     * 操作人id
     */
    private Long operationId;

    /**
     * 操作描述
     */
    private String describe;

    /**
     * ip地址
     */
    private String ip;

}
