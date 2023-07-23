package com.example.principles.InterfaceSegregation.after;

public class ChuanZhiSafeDoor implements Water,Theft{

    @Override
    public void antiTheft() {
        System.out.println("防盗");
    }

    @Override
    public void waterproof() {
        System.out.println("防水");
    }

}
