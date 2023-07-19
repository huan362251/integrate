package com.example.design.StatePattern.client;

import com.example.design.StatePattern.context.AirContext;

/**
 * @Description
 * @Date 2022/11/3 16:16
 * @Author by liu.huan
 */
public class Client {

    public static void main(String[] args) {
        //构造并初始化状态
        AirContext airContext = new AirContext();
        airContext.powerOn();
        airContext.adjustTemp();
        airContext.powerOff();
        System.out.println("关闭后的操作");
        airContext.adjustTemp();

    }

}
