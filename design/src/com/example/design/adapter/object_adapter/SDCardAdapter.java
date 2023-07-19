package com.example.design.adapter.object_adapter;

public class SDCardAdapter extends SDCard {

    private TFCard tfCard;

    public SDCardAdapter(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSDMsg() {
        System.out.println("开启适配器模式读消息");
        return tfCard.readTFMsg();
    }

    @Override
    public void writeSDMsg(String msg) {
        System.out.println("开户适配器模式写消息");
        tfCard.writeTFMsg(msg);
    }

}
