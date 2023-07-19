package com.example.design.StatePattern.state.contreteState;

import com.example.design.StatePattern.context.AirContext;
import com.example.design.StatePattern.state.AirState;

/**
 * @Description
 * @Date 2022/11/3 15:33
 * @Author by liu.huan
 */
public class OpenState extends AirState {

    @Override
    public void powerOn() {
        System.out.println("电源已开启，");
    }

    @Override
    public void powerOff() {
        this.airContext.setCurrentState(AirContext.STATE_CLOSED);
        this.airContext.powerOff();
    }

    @Override
    public void adjustTemp() {
        this.airContext.setCurrentState(AirContext.ADJUST_TEMP_STATE);
        this.airContext.adjustTemp();
    }

}
