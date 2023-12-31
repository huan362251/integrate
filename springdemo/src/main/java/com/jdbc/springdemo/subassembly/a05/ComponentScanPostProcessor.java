package com.jdbc.springdemo.subassembly.a05;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class ComponentScanPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        try {
            //模拟 @ComponentScan
            ComponentScan componentScan = AnnotationUtils.findAnnotation(Config.class, ComponentScan.class);
            AnnotationBeanNameGenerator generator = new AnnotationBeanNameGenerator();
            if (componentScan != null) {
                for (String p : componentScan.basePackages()) {
    //                System.out.println(p);
                    String path = "classpath*:" + p.replace(".","/") + "/**/*.class";
    //                System.out.println(path);
                    //读取类的元信息工厂，读取的是class文件，可以获取到注解之类的信息
                    CachingMetadataReaderFactory factory = new CachingMetadataReaderFactory();
//                    Resource[] resources = context.getResources(path);
                    Resource[] resources = new PathMatchingResourcePatternResolver().getResources(path);
                    for (Resource resource : resources) {
                        MetadataReader reader = factory.getMetadataReader(resource);
    //                    System.out.println("类名："+reader.getClassMetadata().getClassName());
    //                    System.out.println("是否加了 @Component:" + reader.getAnnotationMetadata().hasAnnotation(Component.class.getName()));
    //                    System.out.println("是否加了 @Component 派生:" + reader.getAnnotationMetadata().hasMetaAnnotation(Component.class.getName()));
                        AnnotationMetadata annotationMetadata = reader.getAnnotationMetadata();
                        if(annotationMetadata.hasAnnotation(Component.class.getName()) || annotationMetadata.hasMetaAnnotation(Component.class.getName())){
                            AbstractBeanDefinition bd = BeanDefinitionBuilder.genericBeanDefinition(reader.getClassMetadata().getClassName()).getBeanDefinition();
                            if (configurableListableBeanFactory instanceof DefaultListableBeanFactory) {
    //                        DefaultListableBeanFactory beanFactory = context.getDefaultListableBeanFactory();
                                DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)configurableListableBeanFactory;
                                String name = generator.generateBeanName(bd, beanFactory);
                                beanFactory.registerBeanDefinition(name, bd);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
