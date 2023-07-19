package com.bawangbai;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jDemoTest {

    public static final Logger logger = LoggerFactory.getLogger(Slf4jDemoTest.class);

    @Test
    public void test(){
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");

        try {
            int i = 1/0;
        } catch (Exception e) {
            logger.error("exception:",e);
        }

    }


}
