package com.example.design.AdapterPattern.adaptee.impl;


import com.example.design.AdapterPattern.adaptee.AdapteeInterface;

/**
 * @Description
 * @Date 2022/11/15 14:16
 * @Author by liu.huan
 */
public class Adaptee implements AdapteeInterface {

    @Override
    public void showLastName(String lastName) {
        System.out.println("Adapted showLastName ! Hello Mr." + lastName);
    }

    @Override
    public void showAge(int age) {
        System.out.println("Adapted showAge, age is :" + age);
    }

}
