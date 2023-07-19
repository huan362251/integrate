package com.example.design.StatePattern.state.contreteState;

import com.example.design.StatePattern.context.AirContext;
import com.example.design.StatePattern.state.AirState;

/**
 * @Description
 * @Date 2022/11/3 15:33
 * @Author by liu.huan
 */
public class ClosedState extends AirState {

    @Override
    public void powerOn() {
        airContext.setCurrentState(AirContext.STATE_OPEN);
        airContext.getCurrentState().powerOn();
    }

    @Override
    public void powerOff() {
        System.out.println("电源已关闭");
    }

    @Override
    public void adjustTemp() {
        System.out.println("关闭电源的调节温度无视");
    }

}
