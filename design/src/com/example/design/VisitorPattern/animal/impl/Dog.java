package com.example.design.VisitorPattern.animal.impl;

import com.example.design.VisitorPattern.animal.Animal;
import com.example.design.VisitorPattern.person.Person;

public class Dog implements Animal {

    @Override
    public void accept(Person person) {
        person.feed(this);
    }

}
