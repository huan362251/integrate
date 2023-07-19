package com.example.design.adapter.class_adapter;

public class SDCardAdapter extends TFCardImpl implements SDCard{

    @Override
    public String readSDMsg() {
        System.out.println("开启适配器模式读消息");
        return readTFMsg();
    }

    @Override
    public void writeSDMsg(String msg) {
        System.out.println("开户适配器模式写消息");
        writeTFMsg(msg);
    }

}
