package com.example.design.decorator.product.equipment;

import com.example.design.decorator.product.EquipmentDecorate;
import com.example.design.decorator.root.GameCharacter;

/**
 * @author Administrator
 */
public class DeathStarEquipment extends EquipmentDecorate {

    private GameCharacter gameCharacter;

    public DeathStarEquipment(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    @Override
    public int harm() {
        return 20 + gameCharacter.harm();
    }
}
