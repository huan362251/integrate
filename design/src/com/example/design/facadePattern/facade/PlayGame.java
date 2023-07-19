package com.example.design.facadePattern.facade;

import com.example.design.facadePattern.base.Data;
import com.example.design.facadePattern.base.Screen;
import com.example.design.facadePattern.base.User;

/**
 * @Description
 * @Date 2022/11/15 11:17
 * @Author by liu.huan
 */
public class PlayGame {

    public void play(){
        User user = new User();
        Data data = new Data();
        Screen screen = new Screen();
        screen.open();
        user.login();
        data.loading();
        System.out.println("开始玩耍");
    }

    public void stop(){
        User user = new User();
        Data data = new Data();
        Screen screen = new Screen();
        data.save();
        user.logOut();
        screen.close();
    }

}
