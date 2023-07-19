package com.jdbc.springdemo.subassembly.a03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class A03Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(A03Application.class, args);
        run.close();
    }

}
