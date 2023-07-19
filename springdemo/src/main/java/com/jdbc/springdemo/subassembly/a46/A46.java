package com.jdbc.springdemo.subassembly.a46;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanExpressionContext;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Configuration
public class A46 {

    public static void main(String[] args) throws NoSuchFieldException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(A46.class);
        DefaultListableBeanFactory beanFactory = context.getDefaultListableBeanFactory();

        ContextAnnotationAutowireCandidateResolver resolver = new ContextAnnotationAutowireCandidateResolver();
        resolver.setBeanFactory(beanFactory);
//        Field home = Bean1.class.getDeclaredField("home");
//        test1(context, resolver, home);
//        Field age = Bean1.class.getDeclaredField("age");
//        test2(context,resolver,age);
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        Field bean3 = Bean2.class.getDeclaredField("bean3");
        test3(context,resolver,bean3);

    }

    public static void test3(AnnotationConfigApplicationContext context, ContextAnnotationAutowireCandidateResolver resolver, Field field) {
        DependencyDescriptor descriptor = new DependencyDescriptor(field, false);
        String value = resolver.getSuggestedValue(descriptor).toString();
        System.out.println(value);

        value = context.getEnvironment().resolvePlaceholders(value);
        System.out.println(value);
        System.out.println(value.getClass());

        Object evaluate = context.getBeanFactory().getBeanExpressionResolver().evaluate(value, new BeanExpressionContext(context.getBeanFactory(), null));
        Object age = context.getBeanFactory().getTypeConverter().convertIfNecessary(evaluate, descriptor.getDependencyType());
        System.out.println(age.getClass());
    }


    public static void test2(AnnotationConfigApplicationContext context, ContextAnnotationAutowireCandidateResolver resolver, Field field) {
        DependencyDescriptor descriptor = new DependencyDescriptor(field, false);
        String value = resolver.getSuggestedValue(descriptor).toString();
        System.out.println(value);
        value = context.getEnvironment().resolvePlaceholders(value);
        System.out.println(value);
        System.out.println(value.getClass());
        Object age = context.getBeanFactory().getTypeConverter().convertIfNecessary(value, descriptor.getDependencyType());
        System.out.println(age.getClass());
    }

    public static void test1(AnnotationConfigApplicationContext context, ContextAnnotationAutowireCandidateResolver resolver, Field field) {
        DependencyDescriptor descriptor = new DependencyDescriptor(field, false);
        String value = resolver.getSuggestedValue(descriptor).toString();
        System.out.println(value);
        System.out.println(context.getEnvironment().resolvePlaceholders(value));
    }

    public class Bean1{
        @Value("${TEMP}")
        private String home;
        @Value("18")
        private int age;
    }

    public class Bean2 {
        @Value("#{@bean3}") // SpringEL       #{SpEL}
        private Bean3 bean3;
    }

    @Component("bean3")
    public class Bean3 {
    }

}
