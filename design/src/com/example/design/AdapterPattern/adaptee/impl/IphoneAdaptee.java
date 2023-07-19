package com.example.design.AdapterPattern.adaptee.impl;


import com.example.design.AdapterPattern.adaptee.PhoneInterface;

/**
 * @Description 被适配的类
 * @Date 2022/11/15 17:15
 * @Author by liu.huan
 */
public class IphoneAdaptee implements PhoneInterface {

    @Override
    public void recharge() {
        System.out.println("苹果手机充电");
    }

}
