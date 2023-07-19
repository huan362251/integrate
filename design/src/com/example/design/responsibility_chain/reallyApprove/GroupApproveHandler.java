package com.example.design.responsibility_chain.reallyApprove;

import com.example.design.responsibility_chain.dto.LeaveRequest;
import com.example.design.responsibility_chain.handle.AskLeaveHandle;

public class GroupApproveHandler extends AskLeaveHandle {

    public GroupApproveHandler() {
        this.approveLeaveNum = 1;
    }

    @Override
    public void setSubmit(LeaveRequest leaveRequest) {
        System.out.println("组长权限不足，提交管理员审批");
        ManageApproveHandler manageApproveHandler = new ManageApproveHandler();
        manageApproveHandler.handle(leaveRequest);
    }

}
