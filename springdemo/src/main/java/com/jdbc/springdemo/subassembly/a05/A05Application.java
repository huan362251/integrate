package com.jdbc.springdemo.subassembly.a05;

import cn.hutool.core.annotation.AnnotationUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;

public class A05Application {

    public static void main(String[] args) throws IOException {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("config", Config.class);
//        //@Configuration @Bean @Import @ImportResource
//        context.registerBean(ConfigurationClassPostProcessor.class);
//        //@MapperScan
//        context.registerBean(MapperScannerConfigurer.class,db->{
//            db.getPropertyValues().add("basePackage","com.jdbc.springdemo.subassembly.a05.mapper");
//        });
//        context.registerBean(ComponentScanPostProcessor.class);

        context.registerBean(AtBeanPostProcessor.class);
        context.registerBean(MapperPostProcessor.class);
        
        context.refresh();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        context.close();
    }
}
