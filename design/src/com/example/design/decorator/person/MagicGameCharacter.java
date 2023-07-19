package com.example.design.decorator.person;

import com.example.design.decorator.root.GameCharacter;

public class MagicGameCharacter extends GameCharacter {

    public MagicGameCharacter() {
        System.out.println("魔法人物，伤害增加5");
        desc = "魔法人物";
    }

    @Override
    public int harm() {
        return 5;
    }

}
