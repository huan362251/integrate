package com.example.design.strategyPattern.strategy.impl;

import com.example.design.strategyPattern.strategy.Strategy;

public class StrategyB implements Strategy {

    @Override
    public void show() {
        System.out.println("元宵到");
    }

}
