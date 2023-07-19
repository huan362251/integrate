package com.example.design.decorator.product.equipment;

import com.example.design.decorator.product.EquipmentDecorate;
import com.example.design.decorator.root.GameCharacter;

/**
 * @author Administrator
 */
public class MagicStaffEquipment extends EquipmentDecorate {

    private GameCharacter gameCharacter;

    public MagicStaffEquipment(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    @Override
    public int harm() {
        return 15 + gameCharacter.harm();
    }
}
