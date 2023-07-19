package com.example.design.facadePattern.client;

import com.example.design.facadePattern.facade.PlayGame;

/**
 * @Description
 * @Date 2022/11/15 11:21
 * @Author by liu.huan
 */
public class Client {

    public static void main(String[] args) {
        PlayGame playGame = new PlayGame();
        playGame.play();
        System.out.println("------------");
        playGame.stop();
    }

}
