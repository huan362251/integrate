package com.example.principles.LawDemeter;

public class Fans {

    private String name;

    public Fans(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
