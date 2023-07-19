package com.jdbc.springdemo.subassembly.a41;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Indexed;

import java.util.List;

public class A41 {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.setAllowBeanDefinitionOverriding(true);
        context.registerBean("config",Config.class);
        context.registerBean(ConfigurationClassPostProcessor.class);
        context.refresh();
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

    @Configuration
    @Import(MyImport.class)

    static class Config {

    }

    static class MyImport implements DeferredImportSelector {
        @Override
        public String[] selectImports(AnnotationMetadata importingClassMetadata) {
            List<String> list = SpringFactoriesLoader.loadFactoryNames(MyImport.class, null);
            return list.toArray(new String[0]);
        }
    }

    @Configuration
    static class AutoConfig1 {
        @Bean
        public Bean1 bean1() {
            return new Bean1();
        }
    }

    @Configuration
    static class AutoConfig2 {
        @Bean
        public Bean2 bean2() {
            return new Bean2();
        }
    }


    static class Bean1 {
        public Bean1() {
            System.out.println("创建Bean1");
        }
    }

    static class Bean2 {
        public Bean2() {
            System.out.println("创建Bean2");
        }
    }
}
