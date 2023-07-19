package com.bawangbai.elastic.search.pojo.es;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Document(indexName = "system_log")
@ApiModel(value = "SystemLog", description = "ES系统日志实体类")
public class SystemLogDO implements Serializable {

    private static final long serialVersionUID = 217797418786116477L;
    /**
     * 商品ID
     */
    @Id
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 交易流水号
     */
    @Field(type= FieldType.Long)
    @ApiModelProperty(value = "交易流水号")
    private Long txnId;

    /**
     * 商户订单号
     */
    @Field(type = FieldType.Keyword)
    private String merchantOrderNumber;

    /**
     * 线程号
     */
    @Field(type = FieldType.Keyword)
    private String threadId;

    /**
     * 商户号
     */
    @Field(type= FieldType.Long)
    private Long merchantNo;


    /**
     * 原交易流水号
     */
    @Field(type= FieldType.Long)
    private Long oriTxnId;

    /**
     * 日志生成时间
     */
    @Field(type=FieldType.Date,format = DateFormat.date_hour_minute_second_millis)
    private LocalDateTime generateTime;

    /**
     * 日志生成时间
     */
//    @Field(type=FieldType.Date,format = DateFormat.date_hour_minute_second_millis)
//    private LocalDateTime generateTimeOne;

    /**
     * 详情
     */
    @Field(type= FieldType.Keyword)
    private String details;




}
