package com.ref;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.ref.PrivateTest");
        Object o = aClass.newInstance();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name.get(o));
        name.set(o,"白胖胖");
        System.out.println(name.get(o));
        Method getName = aClass.getMethod("getName");
        Object invoke = getName.invoke(o);
        System.out.println(invoke);
    }

    public static void m4() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.ref.Cat");
        Object o = aClass.newInstance();
        System.out.println(aClass);//获取对象
        System.out.println(aClass.getClass());//获取Class
        Cat cat = new Cat();
        cat.name = "张三";
        cat.age = 10;
        Cat cat1 = new Cat();
        cat1.name = "李四";
        cat1.age = 20;
        Class<? extends Cat> aClass1 = cat.getClass();
        Field name = aClass1.getField("name");
        System.out.println(name.get(cat));
        Field age = aClass1.getField("age");
        System.out.println(age.get(cat1));
    }

    public static void m1(){
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void m2() throws Exception {

        Class<?> aClass = Class.forName("com.ref.Cat");
        long start = System.currentTimeMillis();
        Method method = aClass.getMethod("hi");
        Cat cat = new Cat();
        for (int i = 0; i < 900000000; i++) {
            method.invoke(cat);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void m3() throws Exception {
        Class<?> aClass = Class.forName("com.ref.Cat");
        long start = System.currentTimeMillis();
        Method method = aClass.getMethod("hi");
        Cat cat = new Cat();
        method.setAccessible(true);
        for (int i = 0; i < 900000000; i++) {
            method.invoke(cat);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
