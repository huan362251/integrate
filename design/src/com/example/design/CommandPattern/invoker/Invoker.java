package com.example.design.CommandPattern.invoker;

import com.example.design.CommandPattern.commond.Command;

import java.util.List;

/**
 * @Description
 * @Date 2022/11/1 14:18
 * @Author by liu.huan
 */
public class Invoker {

    private List<Command> commands;

    public Invoker(List<Command> commands) {
        this.commands = commands;
    }

    public void action(){
        System.out.println("小度智能家居为你服务 --> ");
        for (Command command : commands) {
            command.execute();
        }
    }

}
