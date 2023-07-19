package com.jdbc.springdemo.subassembly.a39;

import org.apache.tomcat.util.descriptor.web.ApplicationParameter;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.*;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.Arrays;

public class A39_3 {

    public static void main(String[] args) throws Exception {
        SpringApplication application = new SpringApplication(A39_3.class);
        application.addInitializers(new ApplicationContextInitializer<ConfigurableApplicationContext>() {
            @Override
            public void initialize(ConfigurableApplicationContext applicationContext) {
                System.out.println("对初始化器增强:" + applicationContext);
            }
        });

        System.out.println("2、封装启动参数");
        DefaultApplicationArguments arguments = new DefaultApplicationArguments(args);

        System.out.println("8、创建容器");
        GenericApplicationContext applicationContext = createApplicationContext(WebApplicationType.SERVLET);
        System.out.println("9、准备容器,因为在构造时是准备好初始化器，在此时才是真正的调用，对其进行增强操作");
        for (ApplicationContextInitializer initializer : application.getInitializers()) {
            //发布初始化事件
            initializer.initialize(applicationContext);
        }
        System.out.println("10、加载Bean定义，即BeanDefinition");
        DefaultListableBeanFactory beanFactory = applicationContext.getDefaultListableBeanFactory();
        //注解式加载
        AnnotatedBeanDefinitionReader reader1 = new AnnotatedBeanDefinitionReader(beanFactory);
        reader1.register(Config.class);
        //配置方式加载
        XmlBeanDefinitionReader reader2 = new XmlBeanDefinitionReader(beanFactory);
        reader2.loadBeanDefinitions(new ClassPathResource("b03.xml"));
        //扫描包方式加载
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanFactory);
        scanner.scan("com.jdbc.springdemo.subassembly.a39.demo");

        System.out.println("11、refresh 容器，即把BeanDefinition加载成实例");
        applicationContext.refresh();

        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println("beanName:" + beanDefinitionName + ",beanNameSource:" + applicationContext.getBeanFactory().getBeanDefinition(beanDefinitionName).getResourceDescription());
        }

        System.out.println("12、执行 runner");
        for (CommandLineRunner value : applicationContext.getBeansOfType(CommandLineRunner.class).values()) {
            value.run(args);
        }
        for (ApplicationRunner value : applicationContext.getBeansOfType(ApplicationRunner.class).values()) {
            value.run(arguments);
        }

        applicationContext.close();
    }

    public static GenericApplicationContext createApplicationContext(WebApplicationType webApplicationType) {
        GenericApplicationContext applicationContext = null;
        switch (webApplicationType) {
            case REACTIVE:
                applicationContext = new AnnotationConfigReactiveWebServerApplicationContext();
                break;
            case SERVLET:
                applicationContext = new AnnotationConfigServletWebServerApplicationContext();
                break;
            case NONE:
                applicationContext = new AnnotationConfigApplicationContext();
                break;
            default:
        }
        return applicationContext;
    }

    @Configuration
    static class Config {

        @Bean
        public Bean1 bean1() {
            return new Bean1();
        }

        @Bean
        public ServletWebServerFactory servletWebServerFactory() {
            return new TomcatServletWebServerFactory();
        }

        @Bean
        public CommandLineRunner commandLineRunner() {
            return new CommandLineRunner() {
                @Override
                public void run(String... args) throws Exception {
                    System.out.println("commandLineRunner()方法参数:" + Arrays.toString(args));
                }
            };
        }

        @Bean
        public ApplicationRunner applicationRunner() {
            return new ApplicationRunner() {
                @Override
                public void run(ApplicationArguments args) throws Exception {
                    System.out.println("applicationRunner()方法参数:" + Arrays.toString(args.getSourceArgs()));
                    System.out.println("applicationRunner()方法参数,带命令行:" + args.getOptionNames());
                    System.out.println("applicationRunner()方法参数,不带命令行:" + args.getNonOptionArgs());
                }
            };
        }
    }

    static class Bean1 {
        public Bean1() {
            System.out.println("构造Bean1");
        }
    }

    static class Bean2 {
        public Bean2() {
            System.out.println("构造Bean2");
        }
    }
}
