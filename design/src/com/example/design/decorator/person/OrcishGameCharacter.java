package com.example.design.decorator.person;

import com.example.design.decorator.root.GameCharacter;

public class OrcishGameCharacter extends GameCharacter {

    public OrcishGameCharacter() {
        System.out.println("兽人人物，伤害增加7");
        desc = "兽人人物";
    }

    @Override
    public int harm() {
        return 7;
    }

}
