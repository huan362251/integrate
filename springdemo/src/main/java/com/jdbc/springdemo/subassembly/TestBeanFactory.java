package com.jdbc.springdemo.subassembly;

import org.apache.ibatis.javassist.runtime.Inner;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

public class TestBeanFactory {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition configBeanDef = BeanDefinitionBuilder.genericBeanDefinition(Config.class).setScope("singleton").getBeanDefinition();
        beanFactory.registerBeanDefinition("config",configBeanDef);
        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        //注册后置处理器
        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values().stream().forEach(beanPostProcessor -> {
            //执行beanfactory的后置处理器
            beanPostProcessor.postProcessBeanFactory(beanFactory);
        });
        //注册bean后置处理器
        beanFactory.getBeansOfType(BeanPostProcessor.class).values().stream().sorted(beanFactory.getDependencyComparator()).forEach(beanPostProcessor -> {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        });
//        beanFactory.setAllowEagerClassLoading(true);
        System.out.println("获取注册后的后置处理器");
        beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println(beanFactory.getBean(BeanOne.class).getBeanTwo());
        System.out.println("---------------分隔线----------------");
        System.out.println(beanFactory.getBean(BeanOne.class).getInter());
    }

    @Configuration
    static class Config {

        @Bean
        public BeanOne BeanOne() {
            return new BeanOne();
        }

        @Bean
        public BeanTwo BeanTwo() {
            return new BeanTwo();
        }

        @Bean
        public BeanThree BeanThree() {
            return new BeanThree();
        }

        @Bean
        public BeanFour BeanFour() {
            return new BeanFour();
        }
    }

    static class BeanOne {
        public BeanOne() {
            System.out.println("构造beanOne");
        }

        @Autowired
        private BeanTwo beanTwo;

        public BeanTwo getBeanTwo(){
            return beanTwo;
        }

        @Resource(name = "BeanFour")
        @Autowired
        private Inter BeanThree;

        public Inter getInter(){
            return this.BeanThree;
        }
    }


    static class BeanTwo {
        public BeanTwo() {
            System.out.println("构造beanTwo");
        }
    }

    interface Inter{

    }

    static class BeanThree implements Inter {
        public BeanThree() {
        }
    }

    static class BeanFour implements Inter {
        public BeanFour() {
        }
    }
}
