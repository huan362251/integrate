package com.example.design.StatePattern.state.contreteState;

import com.example.design.StatePattern.context.AirContext;
import com.example.design.StatePattern.state.AirState;

/**
 * @Description
 * @Date 2022/11/3 15:33
 * @Author by liu.huan
 */
public class AdjustTempState extends AirState {

    @Override
    public void powerOn() {
        System.out.println("调用温度的电源不用理会");
    }

    @Override
    public void powerOff() {
        this.airContext.setCurrentState(AirContext.STATE_CLOSED);
        this.airContext.powerOff();
    }

    @Override
    public void adjustTemp() {
        System.out.println("调用温度");
    }

}
