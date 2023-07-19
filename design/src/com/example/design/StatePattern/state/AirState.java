package com.example.design.StatePattern.state;

import com.example.design.StatePattern.context.AirContext;

/**
 * @Description
 * @Date 2022/11/3 15:31
 * @Author by liu.huan
 */
public abstract class AirState {

    protected AirContext airContext;

    public void setAirContext(AirContext airContext) {
        this.airContext = airContext;
    }

    public abstract void powerOn();

    public abstract void powerOff();

    public abstract void adjustTemp();

}
