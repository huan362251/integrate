package com.example.design.mediatorPattern.Mediation.impl;

import com.example.design.mediatorPattern.Mediation.UnitedNationsMediation;
import com.example.design.mediatorPattern.nation.Nation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UnitedNationsMediationImpl implements UnitedNationsMediation {

    public List<Nation> nations = new ArrayList<>();

    @Override
    public void register(Nation nation) {
        nations.add(nation);
    }

    @Override
    public void transpond(String message,Nation nation) {
        List<Nation> nationList = nations.stream().filter(nation1 -> nation1 != nation).collect(Collectors.toList());
        for (Nation nationInclude : nationList) {
            nationInclude.receiveMessage(message);
        }
    }
}
