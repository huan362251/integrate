package com.example.design.mediatorPattern.nation;

public interface Nation {

    /**
     * 发言
     */
    public void sendMessage(String message);

    /**
     * 接收消息
     */
    public void receiveMessage(String message);

}
