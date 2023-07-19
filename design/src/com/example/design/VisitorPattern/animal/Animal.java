package com.example.design.VisitorPattern.animal;

import com.example.design.VisitorPattern.person.Person;

public interface Animal {

    public void accept(Person person);

}
