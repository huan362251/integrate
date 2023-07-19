package com.example.design.responsibility_chain.reallyApprove;

import com.example.design.responsibility_chain.dto.LeaveRequest;
import com.example.design.responsibility_chain.handle.AskLeaveHandle;

public class BossApproveHandler extends AskLeaveHandle {

    public BossApproveHandler() {
        this.approveLeaveNum = 7;
    }

    @Override
    public void setSubmit(LeaveRequest leaveRequest) {
        System.out.println("最高级审批不通过，不批假");
    }

}
