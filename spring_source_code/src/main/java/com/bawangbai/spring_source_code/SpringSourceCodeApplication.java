package com.bawangbai.spring_source_code;

import com.bawangbai.spring_source_code.listener.Component1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Locale;

@SpringBootApplication
public class SpringSourceCodeApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringSourceCodeApplication.class, args);
        //国际化
        System.out.println(context.getMessage("name", null, Locale.ENGLISH));
        System.out.println(context.getMessage("name", null, Locale.CHINA));
        //读取资源
        Resource[] resources = context.getResources("classpath:application.yml");
        for (Resource resource : resources) {
            System.out.println(resource);
        }
        //获取属性
        System.out.println(context.getEnvironment().getProperty("spring.messages.basename"));
        System.out.println(context.getEnvironment().getProperty("JAVA_HOME"));

        //触发bean的方法
        context.getBean(Component1.class).register();
    }

}
