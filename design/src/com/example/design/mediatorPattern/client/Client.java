package com.example.design.mediatorPattern.client;

import com.example.design.mediatorPattern.Mediation.UnitedNationsMediation;
import com.example.design.mediatorPattern.Mediation.impl.UnitedNationsMediationImpl;
import com.example.design.mediatorPattern.nation.Nation;
import com.example.design.mediatorPattern.nation.impl.ChainNation;
import com.example.design.mediatorPattern.nation.impl.UkNation;
import com.example.design.mediatorPattern.nation.impl.UsaNation;

public class Client {

    public static void main(String[] args) {
        UnitedNationsMediation unitedNationsMediation = new UnitedNationsMediationImpl();
        Nation chainNation = new ChainNation("中国",unitedNationsMediation);
        Nation ukNation = new UkNation("英国",unitedNationsMediation);
        Nation usaNation = new UsaNation("美国", unitedNationsMediation);
        unitedNationsMediation.register(chainNation);
        unitedNationsMediation.register(ukNation);
        unitedNationsMediation.register(usaNation);

        chainNation.sendMessage("闪开，白胖胖要发威了");
        System.out.println("--------------");
        chainNation.sendMessage("白胖胖二次发威");
        System.out.println("--------------");
        ukNation.sendMessage("自由");

    }

}
