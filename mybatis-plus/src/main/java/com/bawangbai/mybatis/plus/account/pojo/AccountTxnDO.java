package com.bawangbai.mybatis.plus.account.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @autor： leo.ma
 * @date： Created in 2019-05-16 09:43
 * @description： 账户交易对象
 * @version： v 0.1
 */
@Data
@TableName("t_spt_account_txn")
public class AccountTxnDO  implements Serializable {
    /**
     * 账户交易ID
     */
    private Long acntTxnId;
    /**
     * 账户交易类型
     */
    private String acntTxnType;
    /**
     * 账户交易完成时间
     */
    private LocalDateTime acntTxnDate;
    /**
     * 状态
     */
    private String status;
    /**
     * 外部请求流水号
     */
    private Long requestId;

    /**
     * 内部系统流水号
     */
    private Long serviceId;

    /**
     * 内部系统类型
     */
    private String serviceType;

    /**
     * 交易订单号
     */
    private Long txnId;

    /**
     * 业务跟踪流水号
     */
    private String externalOrderId;

    /**
     * 业务发生时区
     */
    private String externalOrderTimeZone;
    /**
     * 业务发生时间
     */
    private String externalOrderTime;
    /**
     * 产品类型
     */
    private String productType;
    /**
     * 子产品类型
     */
    private String subProductType;
    /**
     * 交易类型
     */
    private String txnType;

    /**
     * 收款人id
     */
    private Long payeeId;
    /**
     * 收款人类型
     */
    private String payeeType;
    /**
     * 收款人交易金额
     */
    private BigDecimal payeeTxnAmount;
    /**
     * 收款人交易币种
     */
    private String payeeCurrency;
    /**
     * 付款人id
     */
    private Long payerId;
    /**
     * 付款人类型
     */
    private String payerType;
    /**
     * 付款人交易金额
     */
    private BigDecimal payerTxnAmount;
    /**
     * 付款人交易币种
     */
    private String payerCurrency;
    /**
     * 平台
     */
    private String platform;

    /**
     * 展示标记
     */
    private String showFlag;

    /**
     * 系统来源
     */
    private String systemSource;
    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createOpr;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updateOpr;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
