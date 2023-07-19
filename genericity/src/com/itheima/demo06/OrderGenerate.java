package com.itheima.demo06;

import java.util.ArrayList;
import java.util.Random;

public class OrderGenerate<T> implements OrderGen<T> {

    T key;

    @Override
    public T getKey() {
        return key;
    }

    public <T> T getValues(ArrayList<T> list){
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    public static <T> void listValues(T... list){
        for (T t : list) {
            System.out.println(t+"\t"+t.getClass().getSimpleName());
        }
    }

}
