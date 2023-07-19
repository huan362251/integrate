package com.example.design.goujian;

public class MobaiBike extends BikeBuilder{

    @Override
    public void buildFrame() {
        bike.setFrame("Mobai 车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Mobai 车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }

}
