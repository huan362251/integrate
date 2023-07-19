package com.bawangbai.elastic.search.pojo.facade;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SettlementInfoDeatilQueryReq{

    /**
     * 商户号
     */
    private Long orgId;

    /**
     * 结算批次号
     */
    private Long settleBatchNo;

    /**
     * 内部系统流水号
     */
    private Long serviceId;

    /**
     * 卡种
     */
    private String cardType;

    /**
     * 支付产品
     */
    private String productType;
    /**
     * 计费状态
     */
    private String feeStatus;
    /**
     * 交易类型
     */
    private String txnType;
    /**
     * 交易状态
     */
    private String txnStatus;
    /**
     * 结算状态
     */
    private String settleStatus;
    /**
     * 商户订单号
     */
    private String externalOrderId;
    /**
     * 查询条件 - 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startTimes;

    /**
     * 查询条件 - 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endTimes;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime txnStartTimes;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime txnEndTimes;

    /**
     * 运营端、商户端标记
     */
    private String merFlag;

    /**
     * 操作员id
     */
    private Long operatorId;

    /**
     * 操作人名称
     */
    private String operatorName;

}
