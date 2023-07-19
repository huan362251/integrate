package com.jdbc.springdemo.subassembly.a04;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.AutowireCandidateResolver;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author Administrator
 */
public class A04Application {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("bean1",Bean1.class);
        context.registerBean("bean2",Bean2.class);
        context.registerBean("bean3",Bean3.class);
        context.registerBean("bean4",Bean4.class);

        context.getDefaultListableBeanFactory().setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());
        context.registerBean(AutowiredAnnotationBeanPostProcessor.class);// @Autowired @Value
        context.registerBean(CommonAnnotationBeanPostProcessor.class); // @PostConstruct @PreDestroy @Resource

        ConfigurationPropertiesBindingPostProcessor.register(context.getDefaultListableBeanFactory());//@ConfigurationProperties

        context.refresh();

        System.out.println(context.getBean(Bean4.class));

        context.close();
    }
}
