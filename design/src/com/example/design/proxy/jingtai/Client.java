package com.example.design.proxy.jingtai;

import org.junit.Test;

public class Client {

    @Test
    public void test(){
        ProxyPoint proxyPoint = new ProxyPoint();
        proxyPoint.sell();
    }

}
