package com.example.design.proxy.dongtai;

import org.junit.Test;

public class Client {

    @Test
    public void test(){
        ProxyFactory proxyFactory = new ProxyFactory();
        SellTickets objectProxy = proxyFactory.getObjectProxy();
        objectProxy.sell();
    }
}
