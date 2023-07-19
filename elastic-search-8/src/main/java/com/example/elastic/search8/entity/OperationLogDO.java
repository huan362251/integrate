package com.example.elastic.search8.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperationLogDO {

    /**
     * 商品ID
     */
//    @Id
    private Long id;

    /**
     * 操作人
     */
//    @Field(type = FieldType.Keyword)
    private String partnerId;

    /**
     * 请求方式 PUT/POST/GET/
     */
//    @Field(type = FieldType.Keyword)
    private String requestType;

    /**
     * 请求方法名
     */
//    @Field(type = FieldType.Keyword)
    private String requestName;

    /**
     * 操作人id
     */
//    @Field(type = FieldType.Long)
    private Long operationId;

    /**
     * 操作人名称
     */
//    @Field(type = FieldType.Keyword)
    private String operationName;

    /**
     * 请求方法中文名
     */
//    @Field(type = FieldType.Keyword)
    private String requestChineseName;

    /**
     * 用户id
     */
//    @Field(type = FieldType.Long)
    private Long userId;

    /**
     * 商户号
     */
//    @Field(type = FieldType.Long)
    private Long merchantNo;

    /**
     * 用户类型
     */
//    @Field(type = FieldType.Keyword)
    private String userType;

    /**
     * 请求url
     */
//    @Field(type = FieldType.Keyword)
    private String requestUrl;

    /**
     * 日志生成时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime generateTime;

    /**
     * 入参
     */
//    @Field(type = FieldType.Keyword)
    private String param;

    /**
     * 出参
     */
//    @Field(type = FieldType.Keyword)
    private String response;

    /**
     * 操作描述
     */
//    @Field(type = FieldType.Keyword)
    private String describe;

    /**
     * 操作url
     */
//    @Field(type = FieldType.Keyword)
    private String operationUrl;

    /**
     * 标记 merchant-商户端  operation-运营端
     */
//    @Field(type = FieldType.Keyword)
    private String owSource;

    /**
     * 应用版本号-前端
     */
//    @Field(type = FieldType.Text)
    private String owVersion;

    /**
     * IP地址
     */
//    @Field(type = FieldType.Text)
    private String ip;

}
