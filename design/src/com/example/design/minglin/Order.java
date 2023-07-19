package com.example.design.minglin;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private int diningTable;

    private Map<String,Integer> food = new HashMap<>();

    public int getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(int diningTable) {
        this.diningTable = diningTable;
    }

    public Map<String, Integer> getFood() {
        return food;
    }

    public void setFood(String foodName,Integer num) {
        food.put(foodName,num);
    }

}
