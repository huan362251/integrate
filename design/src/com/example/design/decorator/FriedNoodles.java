package com.example.design.decorator;

public class FriedNoodles extends FastFood {

    public FriedNoodles(float price, String desc) {
        super(12, "炒面");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
