package com.example.design.zerenlian;

public class Client {

    public static void main(String[] args) {
        //生成审批链
        GroupLevel groupLevel = new GroupLevel();
        Manager manager = new Manager();
        GeneranManage generanManage = new GeneranManage();
        groupLevel.setNextHandler(manager);
        manager.setNextHandler(generanManage);

        //提请假
        LeaveRequest leaveRequest = new LeaveRequest("张三",3,"找工作");

        //开始
        groupLevel.submit(leaveRequest);

    }

}
