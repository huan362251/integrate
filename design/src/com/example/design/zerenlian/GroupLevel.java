package com.example.design.zerenlian;

public class GroupLevel extends Handler {

    public GroupLevel() {
        super(0, NUM_ONE);
    }

    @Override
    public void handlerLevel(LeaveRequest request) {
        System.out.println("小组长审批：");
        System.out.println("姓名：" + request.getName() + ",天数：" + request.getNum() + ",原因：" + request.getContext());
    }

}
