package com.self.factory.simpleFactory.product.specific;

import com.self.factory.simpleFactory.product.AttackProduct;

public class FistPosition implements AttackProduct {

    @Override
    public void attack() {
        System.out.println("拳法攻击");
    }
}
