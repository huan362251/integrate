package com.example.design.mediatorPattern.nation.impl;

import com.example.design.mediatorPattern.Mediation.UnitedNationsMediation;
import com.example.design.mediatorPattern.nation.Nation;

public class UsaNation implements Nation {

    private String name = "美国";

    private UnitedNationsMediation unitedNationsMediation;

    public UsaNation(String name, UnitedNationsMediation unitedNationsMediation) {
        this.name = name;
        this.unitedNationsMediation = unitedNationsMediation;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + "进行发言：" + message);
        unitedNationsMediation.transpond(message,this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + "收到:" + message);
    }

}
