package com.example.design.adapter.class_adapter;

import org.junit.Test;

public class Client {
    
    @Test
    public void test(){
        Computer computer = new Computer();
        SDCard sdCard = new SDCardImpl();
        System.out.println(computer.readSDCard(sdCard));
    }

    @Test
    public void test1(){
        Computer computer = new Computer();
        SDCard sdCard = new SDCardAdapter();
        System.out.println(computer.readSDCard(sdCard));
    }

}
