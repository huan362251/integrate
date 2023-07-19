package com.example.design.adapter.object_adapter;

public class TFCardImpl implements TFCard {

    @Override
    public String readTFMsg() {
        String msg = "读取TF卡数据";
        return msg;
    }

    @Override
    public void writeTFMsg(String msg) {
        System.out.println("TF卡读取数据msg:" + msg);
    }

}
