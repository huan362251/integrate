package com.example.design.xiangyuan;

public class IBox extends AbstractBox {

    @Override
    public String getShape() {
        return "I";
    }

    @Override
    public void display(String color) {
        System.out.println("颜色 ：" + color);
    }

}
