package com.bawangbai.elastic.search.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue sysLogQueue(){
        return new Queue("system.log",true);
    }
}
