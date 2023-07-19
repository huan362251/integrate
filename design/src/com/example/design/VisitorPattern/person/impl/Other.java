package com.example.design.VisitorPattern.person.impl;

import com.example.design.VisitorPattern.animal.impl.Cat;
import com.example.design.VisitorPattern.animal.impl.Dog;
import com.example.design.VisitorPattern.person.Person;

public class Other implements Person {

    @Override
    public void feed(Dog dog) {
        System.out.println("其他人喂狗");
    }

    @Override
    public void feed(Cat cat) {
        System.out.println("其他喂猫");
    }
}
