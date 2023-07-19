package com.itheima.demo06;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        OrderGenerate<String> orderGenerate = new OrderGenerate<>();
        orderGenerate.key = "abc";
        System.out.println(orderGenerate.getKey());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        System.out.println(orderGenerate.getValues(strings));
        OrderGenerate.listValues("a",1,true,strings);
    }
}
