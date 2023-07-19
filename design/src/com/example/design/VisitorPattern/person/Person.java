package com.example.design.VisitorPattern.person;

import com.example.design.VisitorPattern.animal.impl.Cat;
import com.example.design.VisitorPattern.animal.impl.Dog;

public interface Person {

    public void feed(Dog dog);

    public void feed(Cat cat);

}
