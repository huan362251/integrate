package com.example.design.strategyPattern.client;

import com.example.design.strategyPattern.context.ContextHolder;
import com.example.design.strategyPattern.strategy.impl.StrategyA;
import com.example.design.strategyPattern.strategy.impl.StrategyB;
import com.example.design.strategyPattern.strategy.impl.StrategyC;

public class Client {

    public static void main(String[] args) {
        ContextHolder contextHolder = new ContextHolder(new StrategyA());
        contextHolder.show();
        System.out.println("-------------------");
        contextHolder.setStrategy(new StrategyB());
        contextHolder.show();
        System.out.println("-------------------");
        contextHolder.setStrategy(new StrategyC());
        contextHolder.show();

    }

}
