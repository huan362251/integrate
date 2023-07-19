package com.bawangbai.elastic.search.pojo.es;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 结算明细表
 * @TableName t_stl_settlement_detail
 */
@Data
@Document(indexName = "settlement_detail")
@ApiModel(value = "settlement_detail", description = "结算明细实体类")
public class SettlementDetailESDO {
    /**
     * 主键
     */
    @Id
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 结算批次号
     */
    @Field(type= FieldType.Long)
    @ApiModelProperty(value = "结算批次号")
    private Long settleBatchNo;

    /**
     * 结算日期
     */
    @Field(type=FieldType.Date,format = DateFormat.date)
    private Date settleDate;

    /**
     * 结算状态
     */
    @Field(type = FieldType.Keyword)
    private String settleStatus;

    /**
     * 外部请求号
     */
    @Field(type= FieldType.Long)
    private Long requestId;

    /**
     * 账户交易类型
     */
    @Field(type = FieldType.Keyword)
    private String acntTxnType;

    /**
     * 账户id
     */
    @Field(type= FieldType.Long)
    private Long acntId;

    /**
     * 账户类型
     */
    @Field(type = FieldType.Keyword)
    private String acntType;

    /**
     * 所属客户号
     */
    @Field(type= FieldType.Long)
    private Long userId;

    /**
     * 客户类型
     */
    @Field(type = FieldType.Keyword)
    private String userType;

    /**
     * 对外机构号
     */
    @Field(type= FieldType.Long)
    private Long orgId;

    /**
     * 产品类型
     */
    @Field(type = FieldType.Keyword)
    private String productType;

    /**
     * 子产品类型
     */
    @Field(type = FieldType.Keyword)
    private String subProductType;

    /**
     * 应用id
     */
    @Field(type= FieldType.Long)
    private Long appId;

    /**
     * 交易类型
     */
    @Field(type = FieldType.Keyword)
    private String txnType;

    /**
     * 交易状态 
     */
    @Field(type = FieldType.Keyword)
    private String txnStatus;

    /**
     * 交易金额
     */
    @Field(type = FieldType.Double)
    private BigDecimal txnAmount;

    /**
     * 交易网址
     */
    @Field(type = FieldType.Keyword)
    private String txnWebsite;

    /**
     * Interchange费金额（IC++模式用）
     */
    @Field(type = FieldType.Double)
    private BigDecimal interchangeAmount;

    /**
     * scheme费金额（IC++模式用）
     */
    @Field(type = FieldType.Double)
    private BigDecimal schemeAmount;

    /**
     * markup费金额（IC++模式用）
     */
    @Field(type = FieldType.Double)
    private BigDecimal markupAmount;

    /**
     * 处理费金额
     */
    @Field(type = FieldType.Double)
    private BigDecimal handlingAmount;

    /**
     * 手续费金额
     */
    @Field(type = FieldType.Double)
    private BigDecimal feeAmount;

    /**
     * 保证金金额
     */
    @Field(type = FieldType.Double)
    private BigDecimal depositAmount;

    /**
     * 小计金额
     */
    @Field(type = FieldType.Double)
    private BigDecimal sumAmount;

    /**
     * 结算币种
     */
    @Field(type = FieldType.Keyword)
    private String settleCurrency;

    /**
     * 交易发生时间
     */
//    @Field(type=FieldType.Date,format = DateFormat.date_hour_minute_second_millis)
//    private Date txnTime;

    /**
     * 计费批次号
     */
    @Field(type= FieldType.Long)
    private Long feeBatchNo;

    /**
     * 计费状态
     */
    @Field(type = FieldType.Keyword)
    private String feeStatus;

    /**
     * 计算保证金状态
     */
    @Field(type = FieldType.Keyword)
    private String depositStatus;

    /**
     * 保证金批次号
     */
    @Field(type= FieldType.Long)
    private Long depositBatchNo;

    /**
     * 订单金额
     */
    @Field(type = FieldType.Double)
    private BigDecimal orderAmount;

    /**
     * 订单币种
     */
    @Field(type = FieldType.Keyword)
    private String orderCurrency;

    /**
     * 订单生成时间
     */
    @Field(type=FieldType.Date,format = DateFormat.date_hour_minute_second_millis)
    private LocalDateTime orderTime;

    /**
     * 持卡人卡bin
     */
    @Field(type = FieldType.Keyword)
    private String cardBin;

    /**
     * 所属国家
     */
    @Field(type = FieldType.Keyword)
    private String cardBinCountry;

    /**
     * 卡种
     */
    @Field(type = FieldType.Keyword)
    private String cardType;

    /**
     * 资金方向D,C
     */
    @Field(type = FieldType.Keyword)
    private String direction;

    /**
     * 所属平台
     */
    @Field(type = FieldType.Keyword)
    private String platform;

    /**
     * 内部系统流水号
     */
    @Field(type= FieldType.Long)
    private Long serviceId;

    /**
     * 交易订单号
     */
    @Field(type= FieldType.Long)
    private Long txnId;

    /**
     * 内部系统类型
     */
    @Field(type = FieldType.Keyword)
    private String serviceType;

    /**
     * 业务跟踪流水号
     */
    @Field(type = FieldType.Keyword)
    private String externalOrderId;

    /**
     * 业务发生时间
     */
    @Field(type = FieldType.Keyword)
    private String externalOrderTime;

    /**
     * 业务发生时区
     */
    @Field(type = FieldType.Keyword)
    private String externalOrderTimeZone;

    /**
     * 系统来源
     */
    @Field(type = FieldType.Keyword)
    private String systemSource;

    /**
     * 创建人
     */
    @Field(type = FieldType.Keyword)
    private String createOpr;

    /**
     * 创建时间
     */
    @Field(type=FieldType.Date,format = DateFormat.date_hour_minute_second_millis)
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    @Field(type = FieldType.Keyword)
    private String updateOpr;

    /**
     * 更新时间
     */
    @Field(type=FieldType.Date,format = DateFormat.date_hour_minute_second_millis)
    private LocalDateTime updateTime;

    /**
     * 税费
     */
    @Field(type = FieldType.Double)
    private BigDecimal taxes;

    /**
     * 税费类型 IOF:IOF
     */
    @Field(type = FieldType.Keyword)
    private String taxesType;

    /**
     * 通道币种
     */
    @Field(type = FieldType.Keyword)
    private String channelCurrency;

    /**
     * 税费状态
     */
    @Field(type = FieldType.Keyword)
    private String taxesStatus;

    /**
     * 扩展
     */
    @Field(type = FieldType.Keyword)
    private String expand;

    private static final long serialVersionUID = 1L;
}