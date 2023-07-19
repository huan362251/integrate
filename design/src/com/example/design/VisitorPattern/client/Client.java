package com.example.design.VisitorPattern.client;

import com.example.design.VisitorPattern.animal.impl.Cat;
import com.example.design.VisitorPattern.animal.impl.Dog;
import com.example.design.VisitorPattern.home.Home;
import com.example.design.VisitorPattern.person.Person;
import com.example.design.VisitorPattern.person.impl.Onwer;
import com.example.design.VisitorPattern.person.impl.Other;

public class Client {

    public static void main(String[] args) {
        Person owner = new Onwer();
        Home home = new Home();
        home.add(new Cat());
        home.add(new Dog());
        System.out.println("主人喂养");
        home.action(owner);

        System.out.println("其它人喂养");
        Other other = new Other();
        home.action(other);
    }

}
