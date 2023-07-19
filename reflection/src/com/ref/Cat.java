package com.ref;

public class Cat {

    public String name;

    public int age;

    public void hi(){
//        System.out.println("调用方法hi");

    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
