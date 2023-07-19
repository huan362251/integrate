package com.example.design.minglin;

import java.util.Map;

public class OrderCommand implements Command{

    private SeniorChef seniorChef;

    private Order order;

    public OrderCommand(SeniorChef seniorChef, Order order) {
        this.seniorChef = seniorChef;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println("开始做第"+ order.getDiningTable()+"桌的菜");
        Map<String, Integer> food = order.getFood();
        for (Map.Entry<String, Integer> foodDetail : food.entrySet()) {
            seniorChef.makeFood(foodDetail.getValue(),foodDetail.getKey());
        }
        System.out.println("第"+ order.getDiningTable()+"桌的菜做完了");
    }

}
