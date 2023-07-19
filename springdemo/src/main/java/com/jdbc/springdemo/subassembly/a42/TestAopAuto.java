package com.jdbc.springdemo.subassembly.a42;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.type.AnnotationMetadata;

public class TestAopAuto {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        StandardEnvironment env = new StandardEnvironment();
        env.getPropertySources().addLast(new SimpleCommandLinePropertySource(
                "--spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver",
                "--spring.datasource.url=jdbc:mysql://192.168.56.10:3306/test?serverTimezone=UTC&useSSL=false&characterEncoding=utf-8",
                "--spring.datasource.username=root",
                "--spring.datasource.password=root"
        ));
        AutoConfigurationPackages.register(context.getDefaultListableBeanFactory(), TestAopAuto.class.getPackage().getName());
        context.setEnvironment(env);
        //加载常见的后处理器
        AnnotationConfigUtils.registerAnnotationConfigProcessors(context.getDefaultListableBeanFactory());
        context.registerBean(Config.class);
        context.refresh();
        for (String name : context.getBeanDefinitionNames()) {
            String resourceDescription = context.getBeanDefinition(name).getResourceDescription();
            if (resourceDescription != null)
                System.out.println(name + ",来源："+resourceDescription);
        }
    }

    @Configuration
    @Import(MyImportSelector.class)
    static class Config {

    }

    static class MyImportSelector implements DeferredImportSelector {
        @Override
        public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//            return new String[]{
//                    AopAutoConfiguration.class.getName()
//            };
            return new String[]{
                    DataSourceAutoConfiguration.class.getName(),
                    MybatisPlusAutoConfiguration.class.getName(),
                    DataSourceTransactionManagerAutoConfiguration.class.getName(),
                    TransactionAutoConfiguration.class.getName()
            };
        }
    }
}
