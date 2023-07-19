package com.example.design.adapter.object_adapter;

public class SDCardImpl extends SDCard {

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
