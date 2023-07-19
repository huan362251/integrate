package com.example.design.DecoratorPattern.decorator.impl;

import com.example.design.DecoratorPattern.comment.Car;
import com.example.design.DecoratorPattern.decorator.CarDecorator;

/**
 * @Description
 * @Date 2022/11/17 18:47
 * @Author by liu.huan
 */
public class AutoCar extends CarDecorator {

    public AutoCar(Car car) {
        this.car = car;
    }

    @Override
    public void markCar() {
        super.markCar();
        System.out.println("加载自动驾驶功能");
    }

}
