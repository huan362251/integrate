package com.jdbc.springdemo.subassembly.a39;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class A39_1 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("1.演示获取Bean Definition源");
        SpringApplication application = new SpringApplication(A39_1.class);
        Set<String> sources = new HashSet<>();
        sources.add("classpath:b02.xml");
        application.setSources(sources);
        System.out.println("2.演示推断应用类型");
        Method deduceFromClasspath = WebApplicationType.class.getDeclaredMethod("deduceFromClasspath");
        deduceFromClasspath.setAccessible(true);
        System.out.println("推断应用类型：" + deduceFromClasspath.invoke(null));
        System.out.println("3.演示Application context 初始化容器");
        application.addInitializers(new ApplicationContextInitializer<ConfigurableApplicationContext>() {
            @Override
            public void initialize(ConfigurableApplicationContext applicationContext) {
                GenericApplicationContext applicationContext1 = (GenericApplicationContext) applicationContext;
                applicationContext1.registerBean("bean1", Bean1.class);
            }
        });
        System.out.println("4.演示监听器与事件");
        application.addListeners(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println("事件为：" + event.getClass());
            }
        });
        System.out.println("5.演示主类推断");
        Method mainApplicationClass = SpringApplication.class.getDeclaredMethod("deduceMainApplicationClass");
        mainApplicationClass.setAccessible(true);
        System.out.println("main方法：" + mainApplicationClass.invoke(application));
        ConfigurableApplicationContext context = application.run(args);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println("beanName:" + beanDefinitionName + ",beanNameSource:" + context.getBeanFactory().getBeanDefinition(beanDefinitionName).getResourceDescription());
        }
        context.close();
    }

    class Bean1 {
        public Bean1() {
            System.out.println("构造bean1");
        }
    }

    class Bean2 {
        public Bean2() {
            System.out.println("构造bean2");
        }
    }

    class Bean3 {
        public Bean3() {
            System.out.println("构造bean3");
        }
    }

    @Bean
    public Bean3 Bean3() {
        System.out.println("构造bean3");
        return new Bean3();
    }

    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

}
