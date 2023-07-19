package com.jdbc.springdemo.subassembly.a13;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class A13 {

    interface Foo {
        void foo();

        int bar();
    }

    static class Target implements Foo {
        @Override
        public void foo() {
            System.out.println("foo 测试");
        }

        @Override
        public int bar() {
            System.out.println("bar 测试");
            return 100;
        }
    }

    public static void main(String[] args) {
        Foo foo = new $Proxy0(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before");
                return method.invoke(new Target(),args);
            }
        });
        foo.bar();
        foo.foo();
    }

}
