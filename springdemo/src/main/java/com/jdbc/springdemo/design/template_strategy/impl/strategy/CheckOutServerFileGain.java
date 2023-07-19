package com.jdbc.springdemo.design.template_strategy.impl.strategy;

import com.jdbc.springdemo.design.template_strategy.abstra.FileGain;
import com.jdbc.springdemo.design.template_strategy.util.ServerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CheckOutServerFileGain implements FileGain {

    @Autowired
    private ServerUtil serverUtil;

    @Override
    public void fileGainStrategy() {
        log.info("check out server get file");
        serverUtil.getServerFile();
    }

}
