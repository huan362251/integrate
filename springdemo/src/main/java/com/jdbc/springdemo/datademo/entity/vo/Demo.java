package com.jdbc.springdemo.datademo.entity.vo;

public class Demo {

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.setSub("123");
        sub.setName("abc");
        Parent sub1 = sub;
        System.out.println(sub1);
        Sub sub11 = (Sub) sub1;
        System.out.println(sub11.getName());
    }

}
