package com.example.design.ChainOfResponsibilityPattern.concreteHandle;


import com.example.design.ChainOfResponsibilityPattern.handle.ChainHandle;

/**
 * @Description
 * @Date 2022/10/31 16:10
 * @Author by liu.huan
 */
public class BossApprove extends ChainHandle {

    public BossApprove() {
        setApproveNum(7);
        setRole("老板");
    }

    @Override
    public void setNextHandle(ChainHandle chainHandle) {
        setChainHandle(chainHandle);
    }

}
