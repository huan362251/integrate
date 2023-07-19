package com.example.design.CommandPattern.invoker;

import com.example.design.CommandPattern.commond.CookCommand;

import java.util.List;

/**
 * @Description
 * @Date 2022/11/1 15:17
 * @Author by liu.huan
 */
public class Waiter {

    private List<CookCommand> cookCommands;

    public Waiter(List<CookCommand> cookCommands) {
        this.cookCommands = cookCommands;
    }

    public void sendOn(){
        for (CookCommand cookCommand : cookCommands) {
            cookCommand.executeCommand();
        }
    }

}
