package com.self.singleton;

public class SingleTwo {

    private SingleTwo() {
    }

    private static class SingleTwoHolder {
        private static final SingleTwo INSTANCE = new SingleTwo();
    }

    public static SingleTwo getInstance() {
        return SingleTwoHolder.INSTANCE;
    }

}
