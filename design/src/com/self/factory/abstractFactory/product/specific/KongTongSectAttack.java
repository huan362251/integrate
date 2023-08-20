package com.self.factory.abstractFactory.product.specific;

import com.self.factory.abstractFactory.product.SectAttack;

public class KongTongSectAttack implements SectAttack {
    @Override
    public void plamAttack() {
        System.out.println("崆峒掌法");
    }

    @Override
    public void fistAttack() {
        System.out.println("崆峒拳法");
    }

}
