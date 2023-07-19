package com.jdbc.springdemo.design.template_strategy.impl.strategy.client;

import com.jdbc.springdemo.design.template_strategy.abstra.FileGain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FileContext {

    @Autowired
    private final Map<String,FileGain> stringFileGainMap = new HashMap<>();

    public FileContext(Map<String,FileGain> strategyMap) {
        stringFileGainMap.clear();
        strategyMap.forEach((key,value)->stringFileGainMap.put(key,value));
    }

    //具体执行方法
    public void getFile(String strategy){
        stringFileGainMap.get(strategy).fileGainStrategy();
    }

}
