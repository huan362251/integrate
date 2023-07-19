package com.itheima.demo04;

public class Test {

    public static void main(String[] args) {
        ChildFirst<String> childFirst = new ChildFirst<>();
        childFirst.setProduct("abc");
        System.out.println(childFirst.getProduct());

        ChildSecond childSecond = new ChildSecond();
        childSecond.setProduct(123);
        System.out.println(childSecond.getProduct());
    }
}
