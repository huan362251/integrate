package com.example.design.DecoratorPattern.decorator.impl;

import com.example.design.DecoratorPattern.comment.Component;
import com.example.design.DecoratorPattern.decorator.Decorator;

/**
 * @Description
 * @Date 2022/11/16 11:15
 * @Author by liu.huan
 */
public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    private void operationFirst() {
        System.out.println("operationFirst say");
    }

    private void operationLast() {
        System.out.println("operationLast say");
    }

    @Override
    public void operation() {
        operationFirst();
        super.operation();
        operationLast();
    }

    //新功能
    public void anotherOperation() {
        System.out.println("another operation");
    }

}
