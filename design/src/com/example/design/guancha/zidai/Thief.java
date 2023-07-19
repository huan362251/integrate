package com.example.design.guancha.zidai;


import java.util.Observable;

/**
 * 小偷类
 */
public class Thief extends Observable {

    private String name;

    public Thief(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMsg(String msg){
        super.setChanged();
        super.notifyObservers();
    }

}
