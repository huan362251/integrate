package com.jdbc.springdemo.datademo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "demo.user")
@Component
@Data
public class CheckConfig {

    private String id;

}
