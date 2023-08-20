package com.self.factory.simpleFactory.factory;

import com.self.factory.simpleFactory.product.AttackProduct;
import com.self.factory.simpleFactory.product.specific.FistPosition;
import com.self.factory.simpleFactory.product.specific.Palm;

/**
 * @author Administrator
 */
public class MartialArtFactory {

    public AttackProduct createAttack(String type) throws Exception {
        if ("掌".equals(type)){
            return new Palm();
        } else if ("拳".equals(type)) {
            return new FistPosition();
        } else {
            throw new Exception("不存在");
        }
    }

}
