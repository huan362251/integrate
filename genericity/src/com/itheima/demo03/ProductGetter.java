package com.itheima.demo03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductGetter<T> {

    Random random = new Random();

    private T product;

    List<T> list = new ArrayList<>();

    public void addProduct(T t){
        list.add(t);
    }

    public T getProduct(){
        return list.get(random.nextInt(list.size()));
    }

}
