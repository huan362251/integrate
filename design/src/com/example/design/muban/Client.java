package com.example.design.muban;

public class Client {

    public static void main(String[] args) {
        ConcreteClass_BaoCai baoCai = new ConcreteClass_BaoCai();
        baoCai.process();
        System.out.println("================================");
        ConcreteClass_CaiXin caiXin = new ConcreteClass_CaiXin();
        caiXin.process();
    }

}
