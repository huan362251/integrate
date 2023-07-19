package com.example.design.CommandPattern.commond.contrete;

import com.example.design.CommandPattern.commond.Command;
import com.example.design.CommandPattern.receiver.AirConditionerReceiver;

/**
 * @Description
 * @Date 2022/11/1 14:16
 * @Author by liu.huan
 */
public class TurnOnCommand implements Command {

    private AirConditionerReceiver airConditionerReceiver;

    public TurnOnCommand(AirConditionerReceiver airConditionerReceiver) {
        this.airConditionerReceiver = airConditionerReceiver;
    }

    @Override
    public void execute() {
        airConditionerReceiver.turnOn();
    }

}
