package com.self.factory.abstractFactory.study;




import com.self.factory.abstractFactory.factory.MartialArtFactory;
import com.self.factory.abstractFactory.product.XuanHuanAttack;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class StudyXuanBeanFactory {

    private static Map<String, XuanHuanAttack> beanMap = new HashMap<>();

    static {
        Properties properties = new Properties();
        InputStream resourceAsStream = MartialArtFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(resourceAsStream);
            for (Object key : properties.keySet()) {
                Object className = properties.get(key);
                Class aClass = Class.forName((String) className);
                if(aClass.newInstance() instanceof XuanHuanAttack) {
                    XuanHuanAttack o = (XuanHuanAttack) aClass.newInstance();
                    beanMap.put((String) key,o);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static XuanHuanAttack createProduct(String type){
        return beanMap.get(type);
    }

}
