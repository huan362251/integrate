package com.self.singleton;

public class SingletonOne {

    private SingletonOne(){}

    private static SingletonOne singletonOne = new SingletonOne();

    public static SingletonOne getInstance(){
        return singletonOne;
    }

}
