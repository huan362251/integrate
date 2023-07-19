package com.jdbc.springdemo.order.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDate;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liu.huan
 * @since 2022-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_gw_channel_order_info")
public class ChannelOrderInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id")
    private Long id;

    @TableField("order_id")
    private String orderId;

    @TableField("trade_date")
    private LocalDate tradeDate;

    @TableField("opp_user")
    private String oppUser;

    @TableField("opp_code")
    private String oppCode;

    @TableField("tran_ccy")
    private String tranCcy;

    @TableField("tran_amount")
    private BigDecimal tranAmount;

    @TableField("country_code")
    private String countryCode;

    @TableField("custnm")
    private String custnm;

    @TableField("pay_acc_num")
    private String payAccNum;

    @TableField("tra_surplus")
    private String traSurplus;

    @TableField("trade_name")
    private String tradeName;

    @TableField("trade_num")
    private String tradeNum;

    @TableField("unit_price")
    private String unitPrice;

    @TableField("log_track_num")
    private String logTrackNum;

    @TableField("carrier")
    private String carrier;

    @TableField("trade_id")
    private String tradeId;

    @TableField("batch_no")
    private String batchNo;

    @TableField("conv_rate")
    private BigDecimal convRate;

    @TableField("rmk1")
    private String rmk1;

    @TableField("rmk2")
    private String rmk2;

    @TableField("rmk3")
    private String rmk3;


}
