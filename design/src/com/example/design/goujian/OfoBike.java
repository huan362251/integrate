package com.example.design.goujian;

public class OfoBike extends BikeBuilder{

    @Override
    public void buildFrame() {
        bike.setFrame("ofo 车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("ofo 车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }

}
