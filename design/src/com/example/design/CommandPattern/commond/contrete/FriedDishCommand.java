package com.example.design.CommandPattern.commond.contrete;

import com.example.design.CommandPattern.commond.CookCommand;
import com.example.design.CommandPattern.receiver.Chef;

/**
 * @Description
 * @Date 2022/11/1 15:13
 * @Author by liu.huan
 */
public class FriedDishCommand implements CookCommand {

    private Chef chef;

    private String foodName;
    private int foodNum;

    public FriedDishCommand(Chef chef) {
        this.chef = chef;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodNum() {
        return foodNum;
    }

    public void setFoodNum(int foodNum) {
        this.foodNum = foodNum;
    }

    @Override
    public void executeCommand() {
        chef.friedDish(foodName,foodNum);
    }

}
