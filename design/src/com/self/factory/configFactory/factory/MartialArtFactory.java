package com.self.factory.configFactory.factory;

import com.self.factory.configFactory.product.AttackProduct;
import com.self.factory.simpleFactory.product.specific.FistPosition;
import com.self.factory.simpleFactory.product.specific.Palm;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Administrator
 */
public class MartialArtFactory {

    private static Map<String, AttackProduct> beanMap = new HashMap<>();

    static {
        Properties properties = new Properties();
        InputStream resourceAsStream = MartialArtFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(resourceAsStream);
            for (Object key : properties.keySet()) {
                Object className = properties.get(key);
                Class aClass = Class.forName((String) className);
                AttackProduct o =(AttackProduct) aClass.newInstance();
                beanMap.put((String) key,o);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public AttackProduct createProduct(String type){
        return beanMap.get(type);
    }


}
