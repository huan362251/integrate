package com.example.design.proxy.cglib;

import com.example.design.proxy.dongtai.SellTickets;

public class TrainStation implements SellTickets {

    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }

}
