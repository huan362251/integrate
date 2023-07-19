package com.example.design.strategyPattern.context;

import com.example.design.strategyPattern.strategy.Strategy;

public class ContextHolder {

    private Strategy strategy;

    public ContextHolder(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void show(){
        strategy.show();
    }

}
