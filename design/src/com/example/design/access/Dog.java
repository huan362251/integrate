package com.example.design.access;

public class Dog implements Animal {

    @Override
    public void accept(Person person) {
        person.feed(this);
        System.out.println("给狗喂食");
    }

}
