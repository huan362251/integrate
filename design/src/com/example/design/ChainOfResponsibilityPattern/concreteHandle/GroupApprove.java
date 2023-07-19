package com.example.design.ChainOfResponsibilityPattern.concreteHandle;


import com.example.design.ChainOfResponsibilityPattern.handle.ChainHandle;

/**
 * @Description
 * @Date 2022/10/31 16:10
 * @Author by liu.huan
 */
public class GroupApprove extends ChainHandle {

    public GroupApprove() {
        setApproveNum(1);
        setRole("小组长");
    }

    @Override
    public void setNextHandle(ChainHandle chainHandle) {
        setChainHandle(chainHandle);
    }

}
