package com.example.principles.InterfaceSegregation.before;

public class Client {

    public static void main(String[] args) {
        HeiMaSafeDoor heiMaSafeDoor = new HeiMaSafeDoor();
        heiMaSafeDoor.antiTheft();
        heiMaSafeDoor.fireproof();
        heiMaSafeDoor.waterproof();
    }

}
