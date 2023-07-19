package com.example.design.ChainOfResponsibilityPattern.handle;

import cn.hutool.core.util.ObjectUtil;
import com.example.design.ChainOfResponsibilityPattern.reqeuest.ChainRequest;

/**
 * @Description
 * @Date 2022/10/31 16:02
 * @Author by liu.huan
 */
public abstract class ChainHandle {

    /**
     * 审批请假天数
     */
    private int approveNum;

    /**
     * 角色
     */
    private String role;

    /**
     * 链路
     */
    private ChainHandle chainHandle;

    /**
     * 具体处理方案
     */
    public void handle(ChainRequest chainRequest) {

        /*
        能处理则自行处理
        不能处理则抛入下一链路
         */

        //条件->判断是否能自行处理
        if (chainRequest.getNum() < approveNum) {
            System.out.println(role + "自行处理");
        } else if (ObjectUtil.isEmpty(chainHandle)) {
            //看下一链路是否存在，不存在结束
            System.out.println("链路终止，结束");
        } else {
            //下一链路执行
            chainHandle.handle(chainRequest);
        }

    }

    /**
     * 配置下一执行链路
     *
     * @param chainHandle
     */
    public abstract void setNextHandle(ChainHandle chainHandle);

    public void setApproveNum(int approveNum) {
        this.approveNum = approveNum;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setChainHandle(ChainHandle chainHandle) {
        this.chainHandle = chainHandle;
    }

}
