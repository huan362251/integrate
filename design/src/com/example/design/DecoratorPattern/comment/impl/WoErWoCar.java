package com.example.design.DecoratorPattern.comment.impl;

import com.example.design.DecoratorPattern.comment.Car;

/**
 * @Description
 * @Date 2022/11/17 18:44
 * @Author by liu.huan
 */
public class WoErWoCar extends Car {

    @Override
    public void markCar() {
        System.out.println("制造沃尔沃");
    }

}
