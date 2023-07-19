package com.example.design.DecoratorPattern.client;

import com.example.design.DecoratorPattern.comment.Car;
import com.example.design.DecoratorPattern.comment.impl.AoDiCar;
import com.example.design.DecoratorPattern.comment.impl.BaoMaCar;
import com.example.design.DecoratorPattern.comment.impl.WoErWoCar;
import com.example.design.DecoratorPattern.decorator.Decorator;
import com.example.design.DecoratorPattern.decorator.impl.AutoCar;
import com.example.design.DecoratorPattern.decorator.impl.FiyCar;
import com.example.design.DecoratorPattern.decorator.impl.ShuiCar;

/**
 * @Description
 * @Date 2022/11/17 18:49
 * @Author by liu.huan
 */
public class CarClient {


    public static void main(String[] args) {
        Car aoDiCar = new AoDiCar();
        Car baoMaCar = new BaoMaCar();
        Car woErWoCar = new WoErWoCar();

        AutoCar autoCar = new AutoCar(baoMaCar);
        FiyCar fiyCar = new FiyCar(autoCar);
        ShuiCar shuiCar = new ShuiCar(fiyCar);
        shuiCar.markCar();

    }


}
