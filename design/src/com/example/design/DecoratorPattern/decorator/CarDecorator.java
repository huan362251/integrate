package com.example.design.DecoratorPattern.decorator;

import com.example.design.DecoratorPattern.comment.Car;

/**
 * @Description
 * @Date 2022/11/17 18:45
 * @Author by liu.huan
 */
public abstract class CarDecorator extends Car{

    protected Car car;

    @Override
    public void markCar() {
        car.markCar();
    }

}
