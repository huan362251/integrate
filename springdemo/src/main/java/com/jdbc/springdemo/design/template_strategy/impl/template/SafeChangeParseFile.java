package com.jdbc.springdemo.design.template_strategy.impl.template;

import com.jdbc.springdemo.design.template_strategy.abstra.ParseFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SafeChangeParseFile extends ParseFile {

    @Override
    protected void parse() {
        log.info("safe change parse file");
    }

    @Override
    protected void dealData() {
        log.info("safe change deal data");
    }

}
