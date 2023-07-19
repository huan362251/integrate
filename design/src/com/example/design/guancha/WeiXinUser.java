package com.example.design.guancha;

public class WeiXinUser implements Observer {

    private String name;

    public WeiXinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(name + ":" + msg);
    }

}
