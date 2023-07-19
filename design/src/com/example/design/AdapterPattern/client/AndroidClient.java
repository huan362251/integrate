package com.example.design.AdapterPattern.client;


import com.example.design.AdapterPattern.adaptee.impl.IphoneAdaptee;
import com.example.design.AdapterPattern.target.AndroidTarget;
import com.example.design.AdapterPattern.target.impl.AndroidRechange;

/**
 * @Description
 * @Date 2022/11/15 17:19
 * @Author by liu.huan
 */
public class AndroidClient {

    public static void main(String[] args) {

        AndroidTarget androidTarget = new AndroidRechange(new IphoneAdaptee());
        androidTarget.androidRechange();

    }

}
