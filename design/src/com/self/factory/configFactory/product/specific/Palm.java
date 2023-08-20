package com.self.factory.configFactory.product.specific;


import com.self.factory.configFactory.product.AttackProduct;

/**
 * @author Administrator
 */
public class Palm implements AttackProduct {
    @Override
    public void attack() {
        System.out.println("掌法攻击");
    }

}
