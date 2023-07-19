package com.example.design.minglin;

import java.util.ArrayList;
import java.util.List;

public class Waitor {

    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command){
        commands.add(command);
    }

    public void orderUp(){
        for (Command command : commands) {
            command.execute();
        }
    }

}
