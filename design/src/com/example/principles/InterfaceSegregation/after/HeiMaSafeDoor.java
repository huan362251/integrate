package com.example.principles.InterfaceSegregation.after;

public class HeiMaSafeDoor implements Fire,Theft,Water{


    @Override
    public void antiTheft() {
        System.out.println("防盗");
    }

    @Override
    public void fireproof() {
        System.out.println("防火");
    }

    @Override
    public void waterproof() {
        System.out.println("防水");
    }
}
