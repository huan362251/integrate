package com.example.design.zerenlian;

public class Manager extends Handler {

    public Manager() {
        super(NUM_ONE, NUM_THREE);
    }

    @Override
    public void handlerLevel(LeaveRequest request) {
        System.out.println("管理员审批：");
        System.out.println("姓名：" + request.getName() + ",天数：" + request.getNum() + ",原因：" + request.getContext());
    }

}
