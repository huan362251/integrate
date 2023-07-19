package com.example.design.DecoratorPattern.client;

import com.example.design.DecoratorPattern.comment.Component;
import com.example.design.DecoratorPattern.comment.impl.ConcreteComponent;
import com.example.design.DecoratorPattern.decorator.Decorator;
import com.example.design.DecoratorPattern.decorator.impl.ConcreteDecoratorA;

/**
 * @Description
 * @Date 2022/11/16 11:16
 * @Author by liu.huan
 */
public class Client {

    public static void main(String[] args) {
        Component c = new ConcreteComponent();

        Decorator decoratorA = new ConcreteDecoratorA(c);
        decoratorA.operation();

        System.out.println("------------------------------------------------");

        Decorator decoratorBandA = new ConcreteDecoratorA(decoratorA);
        decoratorBandA.operation();

    }

}
