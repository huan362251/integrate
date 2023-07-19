package com.jdbc.springdemo.subassembly.a44;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

public class A44 {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanFactory);
        scanner.scan(A44.class.getPackage().getName());
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println(definitionName);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD,ElementType.TYPE})
    @Conditional(MyCondition1.class)
    @interface ConditionOnClass {
        boolean exists(); //true-存在 false-不存在

        String className(); //判断类的类名
    }

    static class MyCondition1 implements Condition {
        // ⬇️如果存在 Druid 依赖，条件成立
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionOnClass.class.getName());
            String className = attributes.get("className").toString();
            boolean present = ClassUtils.isPresent(className, null);
            boolean exists = (boolean) attributes.get("exists");
            return exists ? present : !present;
        }
    }


    @ConditionOnClass(className = "com.alibaba.druid.pool.DruidDataSource",exists = true)
    public void bean2(){

    }
}
