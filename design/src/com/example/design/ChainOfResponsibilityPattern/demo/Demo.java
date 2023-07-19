package com.example.design.ChainOfResponsibilityPattern.demo;

/**
 * @Description
 * @Date 2022/10/31 16:26
 * @Author by liu.huan
 */
public class Demo {

    public static void main(String[] args) {

        int i = 10;
        if(i < 10){
            System.out.println(10);
        } else if(i < 20 ){
            System.out.println(20);
        } else if (i < 30 ){
            System.out.println(30);
        } else {
            System.out.println("100");
        }


    }
}
