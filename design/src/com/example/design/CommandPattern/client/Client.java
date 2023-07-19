package com.example.design.CommandPattern.client;

import com.example.design.CommandPattern.commond.contrete.TurnOffCommand;
import com.example.design.CommandPattern.commond.contrete.TurnOnCommand;
import com.example.design.CommandPattern.invoker.Invoker;
import com.example.design.CommandPattern.receiver.AirConditionerReceiver;
import com.example.design.CommandPattern.commond.Command;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Date 2022/11/1 14:19
 * @Author by liu.huan
 */
public class Client {

    public static void main(String[] args) {

        Command turnOnCommand = new TurnOnCommand(new AirConditionerReceiver());
        Command turnOffCommand = new TurnOffCommand(new AirConditionerReceiver());
        List<Command> commands = Arrays.asList(turnOnCommand, turnOffCommand);
        Invoker invoker = new Invoker(commands);
        invoker.action();

    }

}
