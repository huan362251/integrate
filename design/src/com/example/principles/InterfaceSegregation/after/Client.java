package com.example.principles.InterfaceSegregation.after;

public class Client {

    public static void main(String[] args) {
        HeiMaSafeDoor heiMaSafeDoor =new HeiMaSafeDoor();
        heiMaSafeDoor.antiTheft();
        heiMaSafeDoor.fireproof();
        heiMaSafeDoor.waterproof();
        System.out.println("=============");
        ChuanZhiSafeDoor chuanZhiSafeDoor = new ChuanZhiSafeDoor();
        chuanZhiSafeDoor.antiTheft();
        chuanZhiSafeDoor.waterproof();
    }

}
