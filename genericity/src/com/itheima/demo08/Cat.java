package com.itheima.demo08;

public class Cat extends Animal{

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +  "," +
                "name=" + super.getName()+
                '}';
    }
}
