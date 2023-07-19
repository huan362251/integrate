package com.itheima.demo07;

public class Test {

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setFirst("abc");
        Box<Integer> integerBox = new Box<>();
        integerBox.setFirst(123);
//        demo(stringBox);
        demoOne(integerBox);
        Box<Number> numberBox = new Box<>();
        Number number = 9;
        numberBox.setFirst(number);
        demoOne(numberBox);

    }

    public static void demo(Box<Number> box){
        System.out.println(box.getFirst());
    }

    public static void demoOne(Box<?> box){
        System.out.println(box.getFirst());
    }
}
