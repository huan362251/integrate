package com.jdbc.springdemo.design.template_strategy.impl.template;

import com.jdbc.springdemo.design.template_strategy.abstra.ParseFile;
import com.jdbc.springdemo.design.template_strategy.impl.strategy.client.FileContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CheckOutParseFile extends ParseFile {

    @Override
    protected void parse() {
        log.info("check out parse file");
    }

    @Override
    protected void dealData() {
        log.info("check out deal data");
    }

}
