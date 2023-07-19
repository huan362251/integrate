package com.example.design.ChainOfResponsibilityPattern.client;

import com.example.design.ChainOfResponsibilityPattern.concreteHandle.BossApprove;
import com.example.design.ChainOfResponsibilityPattern.concreteHandle.GroupApprove;
import com.example.design.ChainOfResponsibilityPattern.concreteHandle.ManagerApprove;
import com.example.design.ChainOfResponsibilityPattern.reqeuest.ChainRequest;

/**
 * @Description
 * @Date 2022/10/31 16:18
 * @Author by liu.huan
 */
public class ChainClient {

    public static void main(String[] args) {
        ChainRequest chainRequest = new ChainRequest();
        chainRequest.setNum(6);
        chainRequest.setContent("病假");
        GroupApprove groupApprove = new GroupApprove();
        ManagerApprove managerApprove = new ManagerApprove();
        groupApprove.setNextHandle(managerApprove);
        BossApprove bossApprove = new BossApprove();
        managerApprove.setNextHandle(bossApprove);
        groupApprove.handle(chainRequest);
    }

}
