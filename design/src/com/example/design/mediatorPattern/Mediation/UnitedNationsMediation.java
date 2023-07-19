package com.example.design.mediatorPattern.Mediation;

import com.example.design.mediatorPattern.nation.Nation;

public interface UnitedNationsMediation {

    /**
     * 注册到联合国
     * @param nation
     */
    public void register(Nation nation);

    /**
     * 转发消息
     */
    public void transpond(String message,Nation nation);

}
