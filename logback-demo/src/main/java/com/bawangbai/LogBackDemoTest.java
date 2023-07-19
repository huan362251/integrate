package com.bawangbai;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackDemoTest {

    @Test
    public void test (){
        Logger logger = LoggerFactory.getLogger(LogBackDemoTest.class);
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }
}
