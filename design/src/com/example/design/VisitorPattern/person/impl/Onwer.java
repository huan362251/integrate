package com.example.design.VisitorPattern.person.impl;

import com.example.design.VisitorPattern.animal.impl.Cat;
import com.example.design.VisitorPattern.animal.impl.Dog;
import com.example.design.VisitorPattern.person.Person;

public class Onwer implements Person {

    @Override
    public void feed(Dog dog) {
        System.out.println("主人喂狗");
    }

    @Override
    public void feed(Cat cat) {
        System.out.println("主人喂猫");
    }
}
