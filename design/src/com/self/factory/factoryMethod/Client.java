package com.self.factory.factoryMethod;

import com.self.factory.factoryMethod.study.StudyAttack;
import com.self.factory.factoryMethod.factory.MartialArtFactory;
import com.self.factory.factoryMethod.factory.specific.KongTongFactory;
import com.self.factory.factoryMethod.factory.specific.WuDangFactory;

public class Client {

    public static void main(String[] args) {
        MartialArtFactory kongTong = new KongTongFactory();
        StudyAttack combinationAttack = new StudyAttack();
        combinationAttack.studyAttack(kongTong);
        System.out.println("===========");
        kongTong = new WuDangFactory();
        combinationAttack.studyAttack(kongTong);
    }

}
