package com.self.factory.factoryMethod.product.specific;

import com.self.factory.factoryMethod.product.SectAttack;

public class WuDangSectAttack implements SectAttack {
    @Override
    public void plamAttack() {
        System.out.println("武当掌法");
    }

    @Override
    public void fistAttack() {
        System.out.println("武当拳法");
    }

}
