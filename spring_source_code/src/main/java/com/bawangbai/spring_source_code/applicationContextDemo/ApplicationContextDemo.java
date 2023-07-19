package com.bawangbai.spring_source_code.applicationContextDemo;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.Controller;

public class ApplicationContextDemo {

    public static void main(String[] args) {
//        classPath();
//        fileSystemPath();
//        testXmlLoad();
//        testAnnotationConfigApplicationContext();
        testAnnotationConfigServletWebContext();
    }

    @Configuration
    static class WebConfig{

        @Bean
        public ServletWebServerFactory servletWebServerFactory(){
            //借用内置的tomcat容器
            return new TomcatServletWebServerFactory();
        }

        @Bean
        public DispatcherServlet dispatcherServlet(){
            //前置调度器
            return new DispatcherServlet();
        }

        @Bean
        public DispatcherServletRegistrationBean registrationBean(DispatcherServlet dispatcherServlet){
            //把前置调度器注册到bean里，然后注册路径为：/
            return new DispatcherServletRegistrationBean(dispatcherServlet, "/");
        }

        //注册path
        @Bean("/hello")
        public Controller controller1(){
            return (request, response) -> {
                //打印响应
                response.getWriter().print("hello");
                return null;
            };
        }

    }


    @Configuration
    public static class Config{

        @Bean
        public Bean1 bean1(){
            return new Bean1();
        }

        @Bean
        public Bean2 bean2(Bean1 bean1){
            Bean2 bean2 = new Bean2();
            bean2.setBean1(bean1);
            return bean2;
        }

    }


    static class Bean1 {

    }

    static class Bean2 {
        private Bean1 bean1;

        public Bean1 getBean1() {
            return bean1;
        }

        public void setBean1(Bean1 bean1) {
            this.bean1 = bean1;
        }
    }

    /**
     * 教程里最常用的context,但是现在的使用频率没有那么高了
     * 加载beanDefinition,通过resources目录下的文件直接读取,是基于classpath路径下
     */
    public static void classPath(){
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("b01.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        Bean1 bean1 = context.getBean(Bean2.class).getBean1();
        System.out.println(bean1);
    }

    /**
     * 加载beanDefinition,通过指定路径去读取文件
     * 是基于磁盘路径下
     * 它又分相对路径和绝对路径两种，相对路径就是通过src下路径一层一层的，绝对路径就是直接取指定的路径
     */
    public static void fileSystemPath(){
        FileSystemXmlApplicationContext context
                = new FileSystemXmlApplicationContext("src\\main\\resources\\b01.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        Bean1 bean1 = context.getBean(Bean2.class).getBean1();
        System.out.println(bean1);
    }

    /**
     * 展示功能
     */
    public static void testXmlLoad(){
        //定义beanFactory
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //获取所有的beanDefinition名称
        String[] beanDefinitionNames = factory.getBeanDefinitionNames();
        System.out.println("加载前");
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("加载后");
        //把beanDefinition读取到factory里
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        //加载beanDefinition
        reader.loadBeanDefinitions(new ClassPathResource("b01.xml"));
        //获取所有的beanDefinition名称
        beanDefinitionNames = factory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        //上面的功能基本上与之前讲的ClassPathXmlApplicationContext/FileSystemXmlApplicationContext的加载bean是一样的

    }

    /**
     * 现在较为常用的注解方式
     */
    public static void testAnnotationConfigApplicationContext(){
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(Config.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    /**
     * 容器方式
     * 就是并没有使用springBoot的自启动，但是依然是启动了tomcat容器，老师是真的牛逼
     * 像web请求、前后不分离在一起写的，就是使用的这种方式
     */
    public static void testAnnotationConfigServletWebContext(){
        AnnotationConfigServletWebServerApplicationContext context
                = new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);
    }

}
