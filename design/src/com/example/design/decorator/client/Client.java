package com.example.design.decorator.client;

import com.example.design.decorator.person.GunnerGameCharacter;
import com.example.design.decorator.person.MagicGameCharacter;
import com.example.design.decorator.person.OrcishGameCharacter;
import com.example.design.decorator.product.equipment.DeathStarEquipment;
import com.example.design.decorator.product.equipment.MagicStaffEquipment;
import com.example.design.decorator.root.GameCharacter;

public class Client {

    public static void main(String[] args) {
        GameCharacter magic = new GunnerGameCharacter();
        System.out.println("魔术师白板伤害："+magic.harm());
        GameCharacter magicEquipmentDeathStar = new DeathStarEquipment(magic);
        System.out.println("魔术师装备死星后伤害："+magicEquipmentDeathStar.harm());
        GameCharacter magicTwice = new MagicStaffEquipment(magicEquipmentDeathStar);
        System.out.println("魔术师装备死星+魔法杖后伤害："+magicTwice.harm());
    }
}
