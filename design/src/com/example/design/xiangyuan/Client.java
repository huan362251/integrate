package com.example.design.xiangyuan;

public class Client {

    public static void main(String[] args) {
        AbstractBox i = BoxFactory.getInstance().getShape("I");
        i.display("蓝色");
        AbstractBox i1 = BoxFactory.getInstance().getShape("I");
        i1.display("绿色");
        System.out.println(i == i1);
        System.out.println("形状:" + i.getShape());
        System.out.println("形状:" + i1.getShape());
    }
}
