package com.example.design.DecoratorPattern.decorator.impl;

import com.example.design.DecoratorPattern.comment.Car;
import com.example.design.DecoratorPattern.decorator.CarDecorator;

/**
 * @Description
 * @Date 2022/11/17 18:47
 * @Author by liu.huan
 */
public class FiyCar extends CarDecorator {

    public FiyCar(Car car) {
        this.car = car;
    }

    @Override
    public void markCar() {
        super.markCar();
        System.out.println("加载飞行功能");
    }

}
