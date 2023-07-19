package com.bawangbai.boot_log;

import com.bawangbai.boot_log.log.Log4j2DemoTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootLogApplicationTests {

    @Test
    void contextLoads() {
    }


    public static final Logger logger = LogManager.getLogger(Log4j2DemoTest.class);

    @Test
    public void test(){
        logger.fatal("fatal");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }
}
