package com.example.design.StatePattern.context;

import com.example.design.StatePattern.state.AirState;
import com.example.design.StatePattern.state.contreteState.AdjustTempState;
import com.example.design.StatePattern.state.contreteState.ClosedState;
import com.example.design.StatePattern.state.contreteState.OpenState;

/**
 * @Description
 * @Date 2022/11/3 15:30
 * @Author by liu.huan
 */
public class AirContext {

    public static final OpenState STATE_OPEN = new OpenState();
    public static final ClosedState STATE_CLOSED = new ClosedState();
    public static final AdjustTempState ADJUST_TEMP_STATE = new AdjustTempState();

    private AirState currentState = STATE_CLOSED;

    public AirContext() {
        this.currentState.setAirContext(this);
    }

    public AirState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(AirState currentState) {
        this.currentState = currentState;
        this.currentState.setAirContext(this);
    }

    public void powerOn() {
        currentState.powerOn();
    }

    public void powerOff() {
        currentState.powerOff();
    }

    public void adjustTemp() {
        currentState.adjustTemp();
    }

}
