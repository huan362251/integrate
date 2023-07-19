package com.jdbc.springdemo.subassembly.a04;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "asl")
public class Bean4 {

    private String log;

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    @Override
    public String toString() {
        return "Bean4{" +
                "log='" + log + '\'' +
                '}';
    }
}
