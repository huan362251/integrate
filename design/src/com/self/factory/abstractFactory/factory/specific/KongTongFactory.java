package com.self.factory.abstractFactory.factory.specific;

import com.self.factory.abstractFactory.factory.MartialArtFactory;
import com.self.factory.abstractFactory.product.SectAttack;
import com.self.factory.abstractFactory.product.XuanHuanAttack;
import com.self.factory.abstractFactory.product.specific.KongTongSectAttack;
import com.self.factory.abstractFactory.product.specific.WuShi;

public class KongTongFactory implements MartialArtFactory {

    @Override
    public SectAttack createMenPai() {
        return new KongTongSectAttack();
    }

    @Override
    public XuanHuanAttack createXuanHuan() {
        return new WuShi();
    }

}
