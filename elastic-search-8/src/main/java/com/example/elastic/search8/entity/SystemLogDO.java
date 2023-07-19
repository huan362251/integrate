package com.example.elastic.search8.entity;

import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.DateFormat;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Data
public class SystemLogDO {
//
//    /**
//     * 商品ID
//     */
//    @Id
//    private Long id;
//
//    /**
//     * 交易流水号->查询所有线程号->根据所有线程号查出来分页数据，再排序
//     */
//    @Field(type=FieldType.Long)
//    private Long serviceId;
//
//    /**
//     * 商户订单号
//     */
//    @Field(type = FieldType.Keyword)
//    private String merchantOrderNumber;
//
//    /**
//     * 线程号
//     */
//    @Field(type = FieldType.Keyword)
//    private String threadId;
//
//    /**
//     * 商户号
//     */
//    @Field(type=FieldType.Long)
//    private Long merchantNo;
//
//    /**
//     * 原交易流水号
//     */
//    @Field(type=FieldType.Long)
//    private Long oriServiceId;
//
//    /**
//     * 日志生成时间
//     */
//    @Field(type=FieldType.Date,format = DateFormat.date_hour_minute_second)
//    private LocalDateTime generateTime;
//
//    /**
//     * 日志生成时间-毫秒
//     */
//    @Field(type=FieldType.Date,format = DateFormat.date_hour_minute_second_millis)
//    private LocalDateTime generateDateTime;
//
//    /**
//     * 详情
//     */
//    @Field(type=FieldType.Keyword)
//    private String details;
//
//    /**
//     * 系统来源
//     */
//    @Field(type=FieldType.Keyword)
//    private String systemSource;
//
//    /**
//     * 功能描述
//     */
//    @Field(type=FieldType.Keyword)
//    private String functionalDescription;
//
//    /**
//     * 店铺原始地址
//     */
//    @Field(type = FieldType.Keyword)
//    private String shop;
//
//    /**
//     * 支付Id
//     */
//    @Field(type = FieldType.Keyword)
//    private String paymentID;
//
//    /**
//     * 日志来源
//     * shopify交易日志需要补充，历史日志无需变更
//     */
//    @Field(type = FieldType.Keyword)
//    private String source;
//
//    /**
//     * v1系统交易流水号
//     */
//    @Field(type = FieldType.Keyword)
//    private String v1ServiceId;

}
