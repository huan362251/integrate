package com.self.factory.simpleFactory.product.specific;

import com.self.factory.simpleFactory.product.AttackProduct;

/**
 * @author Administrator
 */
public class Palm implements AttackProduct {
    @Override
    public void attack() {
        System.out.println("掌法攻击");
    }

}
