package com.self.singleton;

public class Singleton {

    private static volatile Singleton singleton;
    private static volatile boolean flag = false;

    private Singleton() throws Exception {
        synchronized (Singleton.class) {
            if (singleton != null) {
                throw new Exception("不能重复创建对象");
            }
            flag = true;
        }

    }

    private static Singleton getInstance() throws Exception {
        if (singleton != null) {
            return singleton;
        } else {
            synchronized (Singleton.class) {
                if (singleton != null) {
                    return new Singleton();
                } else {
                    return singleton;
                }
            }
        }
    }

}
