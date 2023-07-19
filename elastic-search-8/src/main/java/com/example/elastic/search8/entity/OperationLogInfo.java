package com.example.elastic.search8.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OperationLogInfo {

    /**
     * ID
     */
    private Long id;

    /**
     * 请求方式 PUT/POST/GET/
     */
    private String requestType;

    /**
     * 请求方法名
     */
    private String requestName;

    /**
     * 操作人id
     */
    private Long operationId;

    /**
     * 操作人名称
     */
    private String operationName;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 请求url
     */
    private String requestUrl;

    /**
     * 日志生成时间
     */
    private LocalDateTime generateTime;

    /**
     * 入参
     */
    private String param;

    /**
     * 出参
     */
    private String response;

    /**
     * 操作描述
     */
    private String describe;

    /**
     * 操作url
     */
    private String operationUrl;

    /**
     * 标记 merchant-商户端  operation-运营端
     */
    private String owSource;

    /**
     * 应用版本号-前端
     */
    private String owVersion;

    /**
     * 商户号
     */
    private Long merchantNo;

    /**
     * IP地址
     */
    private String ip;
}
