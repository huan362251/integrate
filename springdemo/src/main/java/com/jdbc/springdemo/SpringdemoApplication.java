package com.jdbc.springdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
@MapperScan("com.jdbc.springdemo.**.mapper")
public class SpringdemoApplication {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringdemoApplication.class, args);
        System.out.println(context);
        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Map<String, Object> stringObjectMap = (Map<String, Object>) singletonObjects.get(beanFactory);
        stringObjectMap.entrySet().stream().filter(entry -> entry.getKey().startsWith("comp")).forEach(e -> {
			System.out.println(e.getKey() + "=" + e.getValue());
                });
		System.out.println(context.getMessage("name", null, Locale.ENGLISH));
		System.out.println(context.getMessage("name", null, Locale.CHINA));
		Resource[] resources = context.getResources("classpath:*");
		for (Resource resource : resources) {
			System.out.println(resource.getFilename());
		}
		System.out.println(context.getEnvironment().getProperty("server.port"));
	}

}
