package com.example.design.access;

public class Client {

    public static void main(String[] args) {
        Home home = new Home();
        home.add(new Cat());
        home.add(new Dog());
        Person person = new SomeOne();
        home.accept(person);
    }

}
