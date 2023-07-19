package com.example.design.ChainOfResponsibilityPattern.concreteHandle;

import com.example.design.ChainOfResponsibilityPattern.handle.ChainHandle;

/**
 * @Description
 * @Date 2022/10/31 16:10
 * @Author by liu.huan
 */
public class ManagerApprove extends ChainHandle {

    public ManagerApprove() {
        this.setApproveNum(3);
        this.setRole("管理员");
    }

    @Override
    public void setNextHandle(ChainHandle chainHandle) {
        setChainHandle(chainHandle);
    }

}
