package com.itheima.demo05;

public class Test {

    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println(apple.getKey());

        Pair<String,Integer> pair = new Pair<>("销售额",100);
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
    }


}
