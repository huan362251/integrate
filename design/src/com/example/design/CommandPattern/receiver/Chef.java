package com.example.design.CommandPattern.receiver;

/**
 * @Description
 * @Date 2022/11/1 15:08
 * @Author by liu.huan
 */
public class Chef {

    public void friedDish(String foodName,int num){
        System.out.println("chef friedDish : " + foodName + " ,num:" + num);
    }

    public void cancleFriedDish(String foodName,int num){
        System.out.println("chef cancle friedDish : " + foodName + " ,num:" + num);
    }

    public void markSoup(String foodName,int num){
        System.out.println("chef markSoup : " + foodName + " ,num:" + num);
    }

    public void cancleMarkSoup(String foodName,int num){
        System.out.println("chef markSoup : " + foodName + " ,num:" + num);
    }

}
