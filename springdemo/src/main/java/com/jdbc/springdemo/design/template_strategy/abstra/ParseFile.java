package com.jdbc.springdemo.design.template_strategy.abstra;

import com.jdbc.springdemo.constr.StrategyEnum;
import com.jdbc.springdemo.design.template_strategy.entity.ParseEntity;
import com.jdbc.springdemo.design.template_strategy.impl.strategy.client.FileContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public abstract class ParseFile {

    @Autowired
    private FileContext fileContext;

    public final void parseData(ParseEntity parseEntity) {
        getFile(StrategyEnum.matchValue(parseEntity.getFileGainType()));
        parse();
        dealData();
        saveAndSendDate();
    }

    public void getFile(String type) {
        fileContext.getFile(type);
    }

    protected abstract void parse();

    protected abstract void dealData();

    void saveAndSendDate() {
        log.info("保存数据和发送消息");
    }
}
