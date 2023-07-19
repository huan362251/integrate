package com.itheima.demo08;

public class MiniCat extends Cat{

    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public MiniCat(String name, int age, int level) {
        super(name, age);
        this.level = level;
    }

    @Override
    public String toString() {
        return "MiniCat{" +
                "level=" + level +
                '}';
    }

}
