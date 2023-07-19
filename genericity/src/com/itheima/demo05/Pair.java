package com.itheima.demo05;

public class Pair<T,K> implements Generic<T>{

    private T key;

    private K value;

    public Pair(T key, K value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public T getKey() {
        return key;
    }

    public K getValue() {
        return value;
    }

}
