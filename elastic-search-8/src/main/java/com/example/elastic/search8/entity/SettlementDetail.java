package com.example.elastic.search8.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 结算明细表
 * @TableName t_stl_settlement_detail
 */
@Data
@TableName(value = "t_stl_settlement_detail")
public class SettlementDetail implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 结算批次号
     */
    private Long settleBatchNo;

    /**
     * 结算日期
     */
    private Date settleDate;

    /**
     * 结算状态
     */
    private String settleStatus;

    /**
     * 外部请求号
     */
    private Long requestId;

    /**
     * 账户交易类型
     */
    private String acntTxnType;

    /**
     * 账户id
     */
    private Long acntId;

    /**
     * 账户类型
     */
    private String acntType;

    /**
     * 所属客户号
     */
    private Long userId;

    /**
     * 客户类型
     */
    private String userType;

    /**
     * 对外机构号
     */
    private Long orgId;

    /**
     * 产品类型
     */
    private String productType;

    /**
     * 子产品类型
     */
    private String subProductType;

    /**
     * 应用id
     */
    private Long appId;

    /**
     * 交易类型
     */
    private String txnType;

    /**
     * 交易状态 
     */
    private String txnStatus;

    /**
     * 交易金额
     */
    private BigDecimal txnAmount;

    /**
     * 交易网址
     */
    private String txnWebsite;

    /**
     * Interchange费金额（IC++模式用）
     */
    private BigDecimal interchangeAmount;

    /**
     * scheme费金额（IC++模式用）
     */
    private BigDecimal schemeAmount;

    /**
     * markup费金额（IC++模式用）
     */
    private BigDecimal markupAmount;

    /**
     * 处理费金额
     */
    private BigDecimal handlingAmount;

    /**
     * 手续费金额
     */
    private BigDecimal feeAmount;

    /**
     * 保证金金额
     */
    private BigDecimal depositAmount;

    /**
     * 小计金额
     */
    private BigDecimal sumAmount;

    /**
     * 结算币种
     */
    private String settleCurrency;

    /**
     * 交易发生时间
     */
    private LocalDateTime txnTime;

    /**
     * 计费批次号
     */
    private Long feeBatchNo;

    /**
     * 计费状态
     */
    private String feeStatus;

    /**
     * 计算保证金状态
     */
    private String depositStatus;

    /**
     * 保证金批次号
     */
    private Long depositBatchNo;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单币种
     */
    private String orderCurrency;

    /**
     * 订单生成时间
     */
    private LocalDateTime orderTime;

    /**
     * 持卡人卡bin
     */
    private String cardBin;

    /**
     * 所属国家
     */
    private String cardBinCountry;

    /**
     * 卡种
     */
    private String cardType;

    /**
     * 资金方向D,C
     */
    private String direction;

    /**
     * 所属平台
     */
    private String platform;

    /**
     * 内部系统流水号
     */
    private Long serviceId;

    /**
     * 交易订单号
     */
    private Long txnId;

    /**
     * 内部系统类型
     */
    private String serviceType;

    /**
     * 业务跟踪流水号
     */
    private String externalOrderId;

    /**
     * 业务发生时间
     */
    private String externalOrderTime;

    /**
     * 业务发生时区
     */
    private String externalOrderTimeZone;

    /**
     * 系统来源
     */
    private String systemSource;

    /**
     * 创建人
     */
    private String createOpr;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateOpr;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 税费
     */
    private BigDecimal taxes;

    /**
     * 税费类型 IOF:IOF
     */
    private String taxesType;

    /**
     * 通道币种
     */
    private String channelCurrency;

    /**
     * 税费状态
     */
    private String taxesStatus;

    /**
     * 扩展
     */
    private String expand;

    private static final long serialVersionUID = 1L;
}