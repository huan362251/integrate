package com.example.design.decorator.person;

import com.example.design.decorator.root.GameCharacter;

/**
 * @author Administrator
 */
public class GunnerGameCharacter extends GameCharacter {

    public GunnerGameCharacter() {
        System.out.println("枪手人物，伤害增加6");
        desc = "枪手人物";
    }

    @Override
    public int harm() {
        return 6;
    }

}
