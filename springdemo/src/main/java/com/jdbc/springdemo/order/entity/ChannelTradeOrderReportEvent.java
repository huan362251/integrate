package com.jdbc.springdemo.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 网关系统贸易订单报送事件表
 * </p>
 *
 * @author liu.huan
 * @since 2022-04-18
 */
public class ChannelTradeOrderReportEvent implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * event id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 批次号
     */
    @TableField("batch_no")
    private Long batchNo;

    /**
     * 报送资料 id
     */
    @TableField("report_file_id")
    private String reportFileId;

    /**
     * 报送资料名称
     */
    @TableField("report_file_name")
    private String reportFileName;

    /**
     * 报送资料路径
     */
    @TableField("report_file_path")
    private String reportFilePath;

    /**
     * 返回资料 id
     */
    @TableField("error_file_id")
    private String errorFileId;

    /**
     * 返回资料名称
     */
    @TableField("error_file_name")
    private String errorFileName;

    /**
     * 返回资料路径
     */
    @TableField("error_file_path")
    private String errorFilePath;

    /**
     * 报送标志 I-未报送,P-受理成功,S-报送成功,F-报送有误,C-取消处理
     */
    @TableField("report_flag")
    private String reportFlag;

    /**
     * 处理标志 I-待处理,P-处理中,S-处理成功,F-处理有误,C-取消处理
     */
    @TableField("process_flag")
    private String processFlag;

    /**
     * 渠道端跟踪号
     */
    @TableField("error_trace_id")
    private String errorTraceId;

    /**
     * 错误提示
     */
    @TableField("error_msg")
    private String errorMsg;

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
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新人
     */
    @TableField("update_opr")
    private String updateOpr;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(Long batchNo) {
        this.batchNo = batchNo;
    }

    public String getReportFileId() {
        return reportFileId;
    }

    public void setReportFileId(String reportFileId) {
        this.reportFileId = reportFileId;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public void setReportFileName(String reportFileName) {
        this.reportFileName = reportFileName;
    }

    public String getReportFilePath() {
        return reportFilePath;
    }

    public void setReportFilePath(String reportFilePath) {
        this.reportFilePath = reportFilePath;
    }

    public String getErrorFileId() {
        return errorFileId;
    }

    public void setErrorFileId(String errorFileId) {
        this.errorFileId = errorFileId;
    }

    public String getErrorFileName() {
        return errorFileName;
    }

    public void setErrorFileName(String errorFileName) {
        this.errorFileName = errorFileName;
    }

    public String getErrorFilePath() {
        return errorFilePath;
    }

    public void setErrorFilePath(String errorFilePath) {
        this.errorFilePath = errorFilePath;
    }

    public String getReportFlag() {
        return reportFlag;
    }

    public void setReportFlag(String reportFlag) {
        this.reportFlag = reportFlag;
    }

    public String getProcessFlag() {
        return processFlag;
    }

    public void setProcessFlag(String processFlag) {
        this.processFlag = processFlag;
    }

    public String getErrorTraceId() {
        return errorTraceId;
    }

    public void setErrorTraceId(String errorTraceId) {
        this.errorTraceId = errorTraceId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateOpr() {
        return createOpr;
    }

    public void setCreateOpr(String createOpr) {
        this.createOpr = createOpr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateOpr() {
        return updateOpr;
    }

    public void setUpdateOpr(String updateOpr) {
        this.updateOpr = updateOpr;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "TGwChannelTradeOrderReportEvent{" +
        "id=" + id +
        ", batchNo=" + batchNo +
        ", reportFileId=" + reportFileId +
        ", reportFileName=" + reportFileName +
        ", reportFilePath=" + reportFilePath +
        ", errorFileId=" + errorFileId +
        ", errorFileName=" + errorFileName +
        ", errorFilePath=" + errorFilePath +
        ", reportFlag=" + reportFlag +
        ", processFlag=" + processFlag +
        ", errorTraceId=" + errorTraceId +
        ", errorMsg=" + errorMsg +
        ", remark=" + remark +
        ", createOpr=" + createOpr +
        ", createTime=" + createTime +
        ", updateOpr=" + updateOpr +
        ", updateTime=" + updateTime +
        "}";
    }
}
