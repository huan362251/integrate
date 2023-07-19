package com.example.design.decorator;

public class FriedRice extends FastFood{

    public FriedRice(float price, String desc) {
        super(10, "炒米");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
