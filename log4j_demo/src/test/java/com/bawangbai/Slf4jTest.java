package com.bawangbai;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

public class Slf4jTest {

    @Test
    public void test(){
        LogLog.setInternalDebugging(true);

        //初始化配置
//        BasicConfigurator.configure();
        //获取日志组件
        Logger logger = Logger.getLogger(Slf4jTest.class);
        logger.info("hello log4j");
        for (int i = 0; i < 10000; i++) {
            logger.fatal("fatal");
            logger.error("error");
            logger.warn("warn");
            logger.info("info");
            logger.debug("debug");
            logger.trace("trace");
        }

    }
}
