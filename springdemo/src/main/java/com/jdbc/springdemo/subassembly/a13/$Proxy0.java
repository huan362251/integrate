package com.jdbc.springdemo.subassembly.a13;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class $Proxy0 extends Proxy implements A13.Foo {

    public $Proxy0(InvocationHandler h) {
        //使用Proxy里的InvocationHandler，这样就不需要再自己手动性的创建一个了
        super(h);
    }
    //通过静态，避免每次使用的时候都创建
    private static Method foo;
    private static Method bar;
    static {
        try {
            foo = A13.Foo.class.getMethod("foo");
            bar = A13.Foo.class.getMethod("bar");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void foo() {
        try {
            h.invoke(this,foo,new Object[0]);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public int bar() {
        try {
            Object invoke = h.invoke(this, bar, new Object[0]);
            return (int) invoke;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return 0;
    }
}
