package com.example.design.proxy.jingtai;

public class ProxyPoint implements SellTickets {

    private TrainStation trainStation = new TrainStation();

    @Override
    public void sell() {
        System.out.println("收取卖票手续费");
        trainStation.sell();
    }

}
