package com.example.design.CommandPattern.client;

import com.example.design.CommandPattern.commond.CookCommand;
import com.example.design.CommandPattern.commond.contrete.CancleFriedDishCommand;
import com.example.design.CommandPattern.commond.contrete.CancleMakeSoupCommand;
import com.example.design.CommandPattern.commond.contrete.FriedDishCommand;
import com.example.design.CommandPattern.commond.contrete.MakeSoupCommand;
import com.example.design.CommandPattern.invoker.Waiter;
import com.example.design.CommandPattern.receiver.Chef;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Date 2022/11/1 15:20
 * @Author by liu.huan
 */
public class CookClient {

    public static void main(String[] args) {
        Chef chef = new Chef();
        FriedDishCommand cookCommand = new FriedDishCommand(chef);
        cookCommand.setFoodName("西红柿炒蛋");
        cookCommand.setFoodNum(1);
        FriedDishCommand friedDishCommand = new FriedDishCommand(chef);
        friedDishCommand.setFoodName("土豆丝");
        friedDishCommand.setFoodNum(2);
        MakeSoupCommand makeSoupCommand = new MakeSoupCommand(chef);
        makeSoupCommand.setFoodName("牛肉汤");
        makeSoupCommand.setFoodNum(1);
        List<CookCommand> cookCommands = Arrays.asList(cookCommand, friedDishCommand, makeSoupCommand);
        Waiter waiter = new Waiter(cookCommands);
        waiter.sendOn();
        System.out.println("---------------wait one seconds---------------");
        CancleFriedDishCommand cancleFriedDishCommand = new CancleFriedDishCommand(chef);
        cancleFriedDishCommand.setFoodName("土豆丝");
        cancleFriedDishCommand.setFoodNum(1);
        CancleMakeSoupCommand cancleMakeSoupCommand = new CancleMakeSoupCommand(chef);
        cancleMakeSoupCommand.setFoodNum(1);
        cancleMakeSoupCommand.setFoodName("牛肉汤");
        Waiter waiter1 = new Waiter(Arrays.asList(cancleFriedDishCommand, cancleMakeSoupCommand));
        waiter1.sendOn();
    }

}
