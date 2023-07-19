package com.example.design.decorator;


import org.junit.Test;

public class Client {

    @Test
    public void test() {
        FastFood fastFood = new FriedNoodles(10, "炒面");
        System.out.println("输出炒面价格：" + fastFood.getPrice() + ":" + fastFood.getDesc());

        fastFood = new Egg(fastFood);
        System.out.println("输出加了鸡蛋以后的价格：" + fastFood.cost() + ":" + fastFood.getDesc());

        fastFood = new Egg(fastFood);
        System.out.println("输出加了鸡蛋以后的价格：" + fastFood.cost() + ":" + fastFood.getDesc());

        fastFood = new Bacon(fastFood);
        System.out.println("输出加了鸡蛋以后的价格：" + fastFood.cost() + ":" + fastFood.getDesc());

    }

}
