package com.bawangbai;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

public class JulTest {

    @Test
    public void test(){
        Logger logger = Logger.getLogger("com.bawangbai.JulTest");
        logger.info("hehe");
        logger.log(Level.INFO,"test demo:{0},{1}",new Object[]{"123","345"});

    }

    @Test
    public void testOne() throws IOException {
        Logger logger = Logger.getLogger("com.bawangbai.JulTest");
        logger.setUseParentHandlers(false);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);

        FileHandler fileHandler = new FileHandler("D:\\file\\logs\\jul.log");
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);
        //控制台级别和打印级别还分属不同的控制
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    @Test
    public void testParent() throws IOException {
        InputStream resourceAsStream = JulTest.class.getClassLoader().getResourceAsStream("logging.properties");
        LogManager logManager = LogManager.getLogManager();
        Logger logger = Logger.getLogger("com.bawangbai.JulTest");
        logManager.readConfiguration(resourceAsStream);

        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }


}
