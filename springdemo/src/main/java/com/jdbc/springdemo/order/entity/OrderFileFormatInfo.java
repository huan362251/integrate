package com.jdbc.springdemo.order.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderFileFormatInfo {

    //(订单编号)
    private String orderId;

    //(交易日期 (YYYYMMDD))
    private String tradeDate;

    //    (收款人名称)
    private String oppUser;

    //    (收款人证件号)
    private String oppCode;

    //    (交易币种)
    private String tranCcy;

    //    (交易金额)
    private BigDecimal tranAmount;

    //    (付款人常驻国家)
    private String countryCode;

    //    (付款人名称)
    private String Custnm;

    //    (付款账号)
    private String payAccNum;

    //    (贸易类型)
    private String traSurplus;

    //    (商品名称)
    private String tradeName;

    //    (数量)
    private int tradeNum;

    //    (单价)
    private String unitPrice;

    //    (物流跟踪号)
    private String logTrackNum;

    //    (承运人)
    private String Carrier;

    //    (分发交易流水号)
    private String tradeId;

    //    (文件批次号)
    private String batchNo;

    //    (换算率)
    private BigDecimal convRate;

    private String rmk1;

    private String rmk2;

    private String rmk3;

}
