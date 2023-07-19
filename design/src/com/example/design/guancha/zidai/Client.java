package com.example.design.guancha.zidai;

public class Client {

    public static void main(String[] args) {
        Thief thief = new Thief("法外狂徒张三");
        Policy policy = new Policy("大刀王五");
        thief.addObserver(policy);
        thief.sendMsg("发送通知");
    }

}
