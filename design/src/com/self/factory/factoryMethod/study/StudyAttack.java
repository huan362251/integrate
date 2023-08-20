package com.self.factory.factoryMethod.study;

import com.self.factory.factoryMethod.factory.MartialArtFactory;
import com.self.factory.factoryMethod.product.SectAttack;

public class StudyAttack {

    public SectAttack studyAttack(MartialArtFactory factory){
        SectAttack attack = factory.createAttack();
        attack.plamAttack();
        attack.fistAttack();
        return attack;
    }

}
