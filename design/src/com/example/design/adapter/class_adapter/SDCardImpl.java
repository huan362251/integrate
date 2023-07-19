package com.example.design.adapter.class_adapter;

public class SDCardImpl implements SDCard {

    @Override
    public String readSDMsg() {
        String msg = "读取SD卡数据";
        return msg;
    }

    @Override
    public void writeSDMsg(String msg) {
        System.out.println("SD卡读取数据msg:" + msg);
    }

}
