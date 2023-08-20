package com.self.factory.simpleFactory.study;

import com.self.factory.simpleFactory.factory.MartialArtFactory;
import com.self.factory.simpleFactory.product.AttackProduct;

public class StudyAttack {

    public AttackProduct studyAttack(String type) throws Exception {
        MartialArtFactory martialArtFactory = new MartialArtFactory();
        AttackProduct artFactoryAttack = martialArtFactory.createAttack(type);
        return artFactoryAttack;
    }

}
