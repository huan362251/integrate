package com.jdbc.springdemo.subassembly.a05;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;

import java.io.IOException;
import java.util.Set;

public class AtBeanPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        try {
            //生成二进制class解析工厂
            CachingMetadataReaderFactory factory = new CachingMetadataReaderFactory();
            //获取metadata解析器，并将指定class进行解析
            MetadataReader reader = factory.getMetadataReader(new ClassPathResource("com/jdbc/springdemo/subassembly/a05/Config.class"));
            //获取解析后的元数据，再从元数据中获取方法中带@Bean的集合
            Set<MethodMetadata> methods = reader.getAnnotationMetadata().getAnnotatedMethods(Bean.class.getName());
            //进行遍历
            for (MethodMetadata method : methods) {
                System.out.println(method);
                //获取方法@Bean的参数里带initMethod所对应的值
                String initMethod = method.getAnnotationAttributes(Bean.class.getName()).get("initMethod").toString();
                //生成BeanDefinition构建器
                BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
                //设置config的bean工厂方法，因为Bean是通过设置来进行变更的，Config是工厂，里面的方法叫工厂方法
                builder.setFactoryMethodOnBean(method.getMethodName(), "config");
                //设置BeanDefinition的自动装配方式，用构造、类型、名称等
                builder.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR);
                //设置initMethod的
                if (initMethod.length() > 0) {
                    builder.setInitMethodName(initMethod);
                }
                //生成BeanDefinition
                AbstractBeanDefinition bd = builder.getBeanDefinition();
                //将BeanDefinition和方法名注册到BeanFactory
                if(configurableListableBeanFactory instanceof BeanFactory) {
                    DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) configurableListableBeanFactory;
                    beanFactory.registerBeanDefinition(method.getMethodName(), bd);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
