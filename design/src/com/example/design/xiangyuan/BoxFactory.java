package com.example.design.xiangyuan;

import java.util.HashMap;
import java.util.Map;

public class BoxFactory {

    private Map<String, AbstractBox> map = new HashMap<>();

    public BoxFactory() {
        map.put("I", new IBox());
        map.put("L", new LBox());
        map.put("O", new OBox());
    }

    private static BoxFactory boxFactory = new BoxFactory();

    public static BoxFactory getInstance() {
        return boxFactory;
    }

    public AbstractBox getShape(String name) {
        return map.get(name);
    }


}
