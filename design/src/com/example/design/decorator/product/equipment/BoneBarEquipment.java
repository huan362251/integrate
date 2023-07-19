package com.example.design.decorator.product.equipment;

import com.example.design.decorator.product.EquipmentDecorate;
import com.example.design.decorator.root.GameCharacter;

/**
 * @author Administrator
 */
public class BoneBarEquipment extends EquipmentDecorate {

    private GameCharacter gameCharacter;

    public BoneBarEquipment(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    @Override
    public int harm() {
        return 17 + gameCharacter.harm();
    }
}
