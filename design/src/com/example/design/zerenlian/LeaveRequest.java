package com.example.design.zerenlian;

public class LeaveRequest {

    private String name;

    private int num;

    private String context;

    public LeaveRequest(String name, int num, String context) {
        this.name = name;
        this.num = num;
        this.context = context;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public String getContext() {
        return context;
    }
}
