package com.example.design.proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

    private TrainStation trainStation = new TrainStation();

    public TrainStation getProxyObject() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TrainStation.class);
        enhancer.setCallback(this);
        TrainStation trainStation = (TrainStation) enhancer.create();
        return trainStation;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("收取手续费6元");
        Object invoke = method.invoke(trainStation, objects);
        return invoke;
    }
}
