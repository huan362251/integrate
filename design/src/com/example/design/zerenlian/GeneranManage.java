package com.example.design.zerenlian;

public class GeneranManage extends Handler {

    public GeneranManage() {
        super(NUM_THREE, NUM_SEVEN);
    }

    @Override
    public void handlerLevel(LeaveRequest request) {
        System.out.println("项目经理审批：");
        System.out.println("姓名：" + request.getName() + ",天数：" + request.getNum() + ",原因：" + request.getContext());
    }

}
