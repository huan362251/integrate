package com.example.design.guancha.zidai;

import java.util.Observable;
import java.util.Observer;

public class Policy implements Observer {

    private String name;

    public Policy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(((Thief)o).getName()+":"+ arg + ":" + name);
    }

}
