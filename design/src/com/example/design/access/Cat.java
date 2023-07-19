package com.example.design.access;

public class Cat implements Animal{

    @Override
    public void accept(Person person) {
        person.feed(this);
        System.out.println("给喵喂食");
    }

}
