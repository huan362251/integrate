package com.jdbc.springdemo.subassembly.a14;

import org.springframework.cglib.core.Signature;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class A14 {

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.setMethodInterceptor(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                return method.invoke(target,objects);
                return methodProxy.invokeSuper(o, objects);
            }
        });
        proxy.save();
        proxy.save(1);
        proxy.save(2L);

    }

}
