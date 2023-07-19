package com.bawangbai.apollo_quick;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig
public class ApolloQuickApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApolloQuickApplication.class, args);
    }

}
