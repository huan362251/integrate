package com.example.design.responsibility_chain.client;

import com.example.design.responsibility_chain.dto.LeaveRequest;
import com.example.design.responsibility_chain.reallyApprove.GroupApproveHandler;

public class LeaveClient {

    public static void main(String[] args) {
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setLeaveNum(8);
        leaveRequest.setLeaveContent("出门看猫");
        GroupApproveHandler groupApproveHandler = new GroupApproveHandler();
        groupApproveHandler.handle(leaveRequest);
    }

}
