package com.self.factory.abstractFactory.factory;


import com.self.factory.abstractFactory.product.SectAttack;
import com.self.factory.abstractFactory.product.XuanHuanAttack;

/**
 * @author Administrator
 */
public interface MartialArtFactory {

    SectAttack createMenPai();

    XuanHuanAttack createXuanHuan();

}
