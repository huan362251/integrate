package com.example.design.responsibility_chain.reallyApprove;

import com.example.design.responsibility_chain.dto.LeaveRequest;
import com.example.design.responsibility_chain.handle.AskLeaveHandle;

public class ManageApproveHandler extends AskLeaveHandle {

    public ManageApproveHandler() {
        this.approveLeaveNum = 3;
    }

    @Override
    public void setSubmit(LeaveRequest leaveRequest) {
        System.out.println("管理员权限不足，提交BOSS审批");
        BossApproveHandler bossApproveHandler = new BossApproveHandler();
        bossApproveHandler.handle(leaveRequest);
    }

}
