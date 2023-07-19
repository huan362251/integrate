package com.example.design.VisitorPattern.home;

import com.example.design.VisitorPattern.animal.Animal;
import com.example.design.VisitorPattern.person.Person;

import java.util.ArrayList;
import java.util.List;

public class Home {

    private List<Animal> animals = new ArrayList<>();

    public void add(Animal animal) {
        animals.add(animal);
    }

    public void action(Person person){
        for (Animal animal : animals) {
            animal.accept(person);
        }
    }

}
