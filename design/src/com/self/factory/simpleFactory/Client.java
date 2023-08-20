package com.self.factory.simpleFactory;

import com.self.factory.simpleFactory.product.AttackProduct;
import com.self.factory.simpleFactory.study.StudyAttack;

public class Client {

    public static void main(String[] args) throws Exception {
        StudyAttack studyAttack = new StudyAttack();
        AttackProduct fist = studyAttack.studyAttack("拳");
        fist.attack();
        AttackProduct palm = studyAttack.studyAttack("掌");
        palm.attack();
    }

}
