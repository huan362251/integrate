package com.self.factory.abstractFactory;

import com.self.factory.abstractFactory.product.SectAttack;
import com.self.factory.abstractFactory.product.XuanHuanAttack;
import com.self.factory.abstractFactory.study.StudySectBeanFactory;
import com.self.factory.abstractFactory.study.StudyXuanBeanFactory;



public class Client {

    public static void main(String[] args) {
//        MartialArtFactory wuDangFactory = new WuDangFactory();
//        SectAttack menPai = wuDangFactory.createMenPai();
//        menPai.fistAttack();
//        menPai.plamAttack();
//        XuanHuanAttack xuanHuan = wuDangFactory.createXuanHuan();
//        xuanHuan.xuanJiAttack();
//        xuanHuan.yanHuoAttack();
//        System.out.println("==============");
//        wuDangFactory = new KongTongFactory();
//        SectAttack menPai1 = wuDangFactory.createMenPai();
//        menPai1.plamAttack();
//        menPai1.fistAttack();
//        XuanHuanAttack xuanHuan1 = wuDangFactory.createXuanHuan();
//        xuanHuan1.yanHuoAttack();
//        xuanHuan1.xuanJiAttack();
        SectAttack kongTong = StudySectBeanFactory.createProduct("kongTong");
        XuanHuanAttack wu = StudyXuanBeanFactory.createProduct("wu");
        kongTong.fistAttack();
        kongTong.plamAttack();
        wu.yanHuoAttack();
        wu.xuanJiAttack();
        System.out.println("==================");
        SectAttack wuDang = StudySectBeanFactory.createProduct("wuDang");
        XuanHuanAttack tao = StudyXuanBeanFactory.createProduct("tao");
        wuDang.fistAttack();
        wuDang.plamAttack();
        tao.xuanJiAttack();
        tao.xuanJiAttack();
    }

}
