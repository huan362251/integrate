package com.example.design.proxy.dongtai;

import java.lang.reflect.Proxy;

public class ProxyFactory {

    private TrainStation trainStation = new TrainStation();

    public SellTickets getObjectProxy() {
        return (SellTickets) Proxy.newProxyInstance(
                trainStation.getClass().getClassLoader(),
                trainStation.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("卖票收取手续费五块");
                    method.invoke(proxy, args);
                    return null;
                }
        );
    }

}
