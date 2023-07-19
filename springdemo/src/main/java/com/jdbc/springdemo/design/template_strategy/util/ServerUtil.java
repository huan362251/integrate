package com.jdbc.springdemo.design.template_strategy.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ServerUtil {

    public void getServerFile(){
        log.info("get server file");
    }

}
