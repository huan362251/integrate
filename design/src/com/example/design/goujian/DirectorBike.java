package com.example.design.goujian;

public class DirectorBike {

    private BikeBuilder builder ;

    public DirectorBike(BikeBuilder builder) {
        this.builder = builder;
    }

    public Bike construct(){
        builder.buildSeat();
        builder.buildFrame();
        return builder.createBike();
    }

}
