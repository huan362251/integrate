package com.example.design.responsibility_chain.handle;

import com.example.design.responsibility_chain.dto.LeaveRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * 请假管理类
 */
public abstract class AskLeaveHandle {

    public int approveLeaveNum;

    public void handle(LeaveRequest leaveRequest) {
        if (leaveRequest.getLeaveNum() <= approveLeaveNum) {
            System.out.println("开始进行审批：" + leaveRequest.getLeaveNum() + ",审核内容:" + leaveRequest.getLeaveContent() +"同意！");
            System.out.println("审批结束！");
        } else {
            setSubmit(leaveRequest);
        }
    }

    /**
     * 提交下一审核人
     *
     * @param leaveRequest
     */
    public abstract void setSubmit(LeaveRequest leaveRequest);

}
