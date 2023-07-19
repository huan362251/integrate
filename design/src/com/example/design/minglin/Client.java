package com.example.design.minglin;

public class Client {

    public static void main(String[] args) {
        Order order = new Order();
        order.setDiningTable(1);
        order.setFood("酸菜鱼",1);
        order.setFood("白米饭",2);

        Order order1 = new Order();
        order1.setDiningTable(2);
        order1.setFood("毛血量",1);
        order1.setFood("白米饭",2);
        order1.setFood("可乐",1);

        SeniorChef seniorChef = new SeniorChef();
        Command command = new OrderCommand(seniorChef,order);
        Command command1 = new OrderCommand(seniorChef,order1);

        Waitor waitor = new Waitor();
        waitor.addCommand(command);
        waitor.addCommand(command1);

        waitor.orderUp();
    }

}
