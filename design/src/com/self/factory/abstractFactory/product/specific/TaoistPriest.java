package com.self.factory.abstractFactory.product.specific;

import com.self.factory.abstractFactory.product.XuanHuanAttack;

public class TaoistPriest implements XuanHuanAttack {

    @Override
    public void yanHuoAttack() {
        System.out.println("道士火炎攻击");
    }

    @Override
    public void xuanJiAttack() {
        System.out.println("道士玄技攻击");
    }
}
