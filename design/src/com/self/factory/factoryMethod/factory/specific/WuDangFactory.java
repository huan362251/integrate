package com.self.factory.factoryMethod.factory.specific;

import com.self.factory.factoryMethod.factory.MartialArtFactory;
import com.self.factory.factoryMethod.product.SectAttack;
import com.self.factory.factoryMethod.product.specific.WuDangSectAttack;

public class WuDangFactory implements MartialArtFactory {
    @Override
    public SectAttack createAttack() {
        return new WuDangSectAttack();
    }

}
