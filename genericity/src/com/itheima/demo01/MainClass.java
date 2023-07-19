package com.itheima.demo01;

public class MainClass {

    public static void main(String[] args) {
        Generic<String> stringGeneric = new Generic<>("abc");
        String key = stringGeneric.getKey();
        System.out.println("key:"+key);

        Generic<Integer> integerGeneric = new Generic<>(123);
        Integer key1 = integerGeneric.getKey();
        System.out.println("key1:"+key1);

    }

}
