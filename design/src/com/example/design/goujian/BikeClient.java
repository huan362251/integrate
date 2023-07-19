package com.example.design.goujian;

import java.math.BigDecimal;

public class BikeClient {

    public static void main(String[] args) {
        DirectorBike directorBike = new DirectorBike(new OfoBike());
        Bike construct = directorBike.construct();
        System.out.println(construct.getFrame());
        System.out.println(construct.getSeat());

        CustomBuilder build = new CustomBuilder.Builder().age(12).name("张三").build();
        System.out.println(build.toString());

        BigDecimal bigDecimal = new BigDecimal(213.000000);
        BigDecimal bigDecimal1 = bigDecimal.setScale(0);
        System.out.println(bigDecimal1);

    }

}
