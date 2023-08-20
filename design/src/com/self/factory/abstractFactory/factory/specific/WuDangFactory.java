package com.self.factory.abstractFactory.factory.specific;

import com.self.factory.abstractFactory.factory.MartialArtFactory;
import com.self.factory.abstractFactory.product.SectAttack;
import com.self.factory.abstractFactory.product.XuanHuanAttack;
import com.self.factory.abstractFactory.product.specific.TaoistPriest;
import com.self.factory.abstractFactory.product.specific.WuDangSectAttack;

public class WuDangFactory implements MartialArtFactory {

    @Override
    public SectAttack createMenPai() {
        return new WuDangSectAttack();
    }

    @Override
    public XuanHuanAttack createXuanHuan() {
        return new TaoistPriest();
    }

}
