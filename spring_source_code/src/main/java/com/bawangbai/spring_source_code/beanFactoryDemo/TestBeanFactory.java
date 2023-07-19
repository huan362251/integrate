package com.bawangbai.spring_source_code.beanFactoryDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class TestBeanFactory {

    private static final Logger logger = LoggerFactory.getLogger(TestBeanFactory.class);

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //bean的定义(class、scope、初始化、销毁)
        AbstractBeanDefinition configDefinition =
                BeanDefinitionBuilder.genericBeanDefinition(Config.class).setScope("singleton").getBeanDefinition();//定义bean
        //仅是将bean注册到容器里
        beanFactory.registerBeanDefinition("config", configDefinition);

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();//获取容器中所有bean名称
        System.out.println("--------------注入工厂原始config bean-----------------");
        for (String beanDefinitionName : beanDefinitionNames) {//遍历容器的bean
            System.out.println(beanDefinitionName);
        }
        System.out.println("--------------注入工厂 原始config bean 的后置处理bean-----------------");
        //把beanFactory中的后置处理器注册到beanFactory里去->添加一些常用后处理器
        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);
        beanDefinitionNames = beanFactory.getBeanDefinitionNames();//获取容器中所有bean名称
        for (String beanDefinitionName : beanDefinitionNames) {//遍历容器的bean
            System.out.println(beanDefinitionName);
        }
        System.out.println("--------------获取beanFactory的所有后置处理器bean,然后将后置处理器bean执行  -----------------");
        Map<String, BeanFactoryPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);//获取所有的后置处理器
        //补充了一些bean定义->对原有bean定义的信息做增量
        beansOfType.values().stream().forEach(beanFactoryPostProcessor -> {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);//不太理解，还有可能有多个beanFactory吗
        });
//        beanDefinitionNames = beanFactory.getBeanDefinitionNames();//获取容器中所有bean名称
//        for (String beanDefinitionName : beanDefinitionNames) {//遍历容器的bean
//            System.out.println(beanDefinitionName);
//        }
        beanFactory.preInstantiateSingletons();
//        System.out.println("--------------未执行bean的后置处理器，获取bean1内注入的bean2 -----------------");
//        System.out.println(beanFactory.getBean(Bean1.class).getBean2());
//        beanDefinitionNames = beanFactory.getBeanDefinitionNames();//获取容器中所有bean名称
//        for (String beanDefinitionName : beanDefinitionNames) {//遍历容器的bean
//            System.out.println(beanDefinitionName);
//        }

        System.out.println("--------------执行bean的后置处理器，获取bean1内注入的bean2 -----------------");
        beanFactory.getBeansOfType(BeanPostProcessor.class).values().forEach(beanFactory::addBeanPostProcessor);//添加后置处理器
        beanDefinitionNames = beanFactory.getBeanDefinitionNames();//获取容器中所有bean名称
        for (String beanDefinitionName : beanDefinitionNames) {//遍历容器的bean
            System.out.println(beanDefinitionName);
        }
        System.out.println(beanFactory.getBean(Bean1.class).getBean2());


    }

    @Configuration
    static class Config {
        @Bean
        public Bean1 bean1() {
            return new Bean1();
        }

        @Bean
        public Bean2 bean2() {
            return new Bean2();
        }
    }

    static class Bean1 {
        public Bean1() {
            System.out.println("构造bean1");
        }
        @Autowired
        private Bean2 bean2;
        public Bean2 getBean2() {
            return bean2;
        }
    }

    static class Bean2 {
        public Bean2() {
            System.out.println("构造bean2");
        }
    }

}
