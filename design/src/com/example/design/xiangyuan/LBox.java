package com.example.design.xiangyuan;

public class LBox extends AbstractBox {

    @Override
    public String getShape() {
        return "L";
    }

    @Override
    public void display(String color) {
        System.out.println("颜色 ：" + color);
    }

}
