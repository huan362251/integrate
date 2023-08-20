package com.self.factory.factoryMethod.factory.specific;

import com.self.factory.factoryMethod.factory.MartialArtFactory;
import com.self.factory.factoryMethod.product.SectAttack;
import com.self.factory.factoryMethod.product.specific.KongTongSectAttack;

public class KongTongFactory implements MartialArtFactory {
    @Override
    public SectAttack createAttack() {
        return new KongTongSectAttack();
    }
}
