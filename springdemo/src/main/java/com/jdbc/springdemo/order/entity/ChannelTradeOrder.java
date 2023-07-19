package com.jdbc.springdemo.order.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 网关系统贸易订单表
 * </p>
 *
 * @author liu.huan
 * @since 2022-04-18
 */
@Data
public class ChannelTradeOrder implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 内部流水号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 外部平台名称 如 Amazon,eBay,Standalone
     */
    @TableField("out_platform")
    private String outPlatform;

    /**
     * 外部平台流水号
     */
    @TableField("out_order_no")
    private String outOrderNo;

    /**
     * 外部平台子订单流水号
     */
    @TableField("out_order_item_no")
    private String outOrderItemNo;

    /**
     * 交易时间
     */
    @TableField("trade_time")
    private LocalDate tradeTime;

    /**
     * 物品名称
     */
    @TableField("goods_name")
    private String goodsName;

    /**
     * 物品数量
     */
    @TableField("goods_quantity")
    private Integer goodsQuantity;

    /**
     * 物品单价
     */
    @TableField("item_price")
    private BigDecimal itemPrice;

    /**
     * 单价币种
     */
    @TableField("item_currency")
    private String itemCurrency;

    /**
     * 交易类型，货物贸易,服务贸易,
     */
    @TableField("trade_type")
    private String tradeType;

    /**
     * 承运商
     */
    @TableField("carrier_name")
    private String carrierName;

    /**
     * 承运商服务
     */
    @TableField("carrier_service")
    private String carrierService;

    /**
     * 物流跟踪号
     */
    @TableField("log_track_num")
    private String logTrackNum;

    /**
     * 发货时间
     */
    @TableField("ship_date")
    private Date shipDate;

    /**
     * 支付单号
     */
    @TableField("pay_order_no")
    private String payOrderNo;

    /**
     * 付款人
     */
    @TableField("buyer_name")
    private String buyerName;

    /**
     * 付款人邮箱
     */
    @TableField("buyer_email")
    private String buyerEmail;

    /**
     * 付款人国家或地区,如果不存在,则补充网站所在地区
     */
    @TableField("buyer_county")
    private String buyerCounty;

    /**
     * 商户号
     */
    @TableField("merchant_no")
    private Long merchantNo;

    /**
     * 应用ID
     */
    @TableField("app_id")
    private Long appId;

    /**
     * 订单币种->结算币种 汇率
     */
    @TableField("calc_cur_rate")
    private BigDecimal calcCurRate;

    /**
     * 结算币种
     */
    @TableField("calc_currency")
    private String calcCurrency;

    /**
     * 结算金额
     */
    @TableField("calc_total_amount")
    private BigDecimal calcTotalAmount;

    /**
     * 标记流水号
     */
    @TableField("ex_order_no")
    private String exOrderNo;

    /**
     * 标记批次号
     */
    @TableField("ex_batch_no")
    private String exBatchNo;

    /**
     * 结算币种->报送币种 汇率
     */
    @TableField("conv_rate")
    private BigDecimal convRate;

    /**
     * 报送币种
     */
    @TableField("conv_currency")
    private String convCurrency;

    /**
     * 报送金额
     */
    @TableField("conv_amount")
    private BigDecimal convAmount;

    /**
     * 订单状态 I-invalid 无效的(需要补充完整), V-valid 有效的,  S-success 已使用, U-unavailable 不可用(渠道返回)
     */
    @TableField("status")
    private String status;

    /**
     * 当前流程状态 I-未报送,P-标记中,D-已报送
     */
    @TableField("process_status")
    private String processStatus;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建人
     */
    @TableField("create_opr")
    private String createOpr;

    /**
     * 更新人
     */
    @TableField("update_opr")
    private String updateOpr;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;


}
