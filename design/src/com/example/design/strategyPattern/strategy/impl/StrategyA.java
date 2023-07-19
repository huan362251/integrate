package com.example.design.strategyPattern.strategy.impl;

import com.example.design.strategyPattern.strategy.Strategy;

public class StrategyA implements Strategy {

    @Override
    public void show() {
        System.out.println("春节到");
    }

}
