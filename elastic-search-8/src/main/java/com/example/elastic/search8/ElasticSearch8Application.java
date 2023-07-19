package com.example.elastic.search8;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.elastic.search8.mapper")
public class ElasticSearch8Application {

    public static void main(String[] args) {
        SpringApplication.run(ElasticSearch8Application.class, args);
    }

}
