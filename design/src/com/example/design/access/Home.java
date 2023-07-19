package com.example.design.access;

import java.util.ArrayList;
import java.util.List;

public class Home {

    private List<Animal> nodeList = new ArrayList<>();

    public void add(Animal animal){
        nodeList.add(animal);
    }

    public void accept(Person person){
        for (Animal animal : nodeList) {
            animal.accept(person);
        }
    }

}
