package com.jdbc.springdemo.subassembly.a40;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.coyote.http11.Http11Nio2Protocol;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class TestTomcat {

    public static void main(String[] args) throws LifecycleException, IOException {
        //创建tomcat对象
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("tomcat");
        //创建项目文件夹,即docBase
        File docBase = Files.createTempDirectory("boot.").toFile();
        //项目退出时删除
        docBase.deleteOnExit();
        //创建tomcat项目，在tomcat里称为context
        Context context = tomcat.addContext("", docBase.getAbsolutePath());

        WebApplicationContext applicationContext = getWebApplicationContext();
        //编程添加servlet
        context.addServletContainerInitializer(new ServletContainerInitializer() {
            @Override
            public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
                HelloServlet helloServlet = new HelloServlet();
                ctx.addServlet("aaa", helloServlet).addMapping("/hello");
                for (ServletRegistrationBean registrationBean : applicationContext.getBeansOfType(ServletRegistrationBean.class).values()) {
                    registrationBean.onStartup(ctx);
                }
            }
        }, Collections.emptySet());
        //启动tomcat
        tomcat.start();
        //创建连接器，设置监听接口
        Connector connector = new Connector(new Http11Nio2Protocol());
        connector.setPort(8080);
        tomcat.setConnector(connector);
    }

    //为了建jdk，不能建web的，会自动创建web应用，内置tomcat
    //创建spring容器
    public static WebApplicationContext getWebApplicationContext(){
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(Config.class);
        context.refresh();
        return context;
    }

    @Configuration
    static class Config {
        @Bean
        public DispatcherServletRegistrationBean dispatcherServletRegistrationBean(DispatcherServlet dispatcherServlet) {
            return new DispatcherServletRegistrationBean(dispatcherServlet, "/");
        }

        @Bean
        public DispatcherServlet dispatcherServlet(WebApplicationContext webApplicationContext) {
            return new DispatcherServlet(webApplicationContext);
        }

        @Bean
        public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
            RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
            List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
            messageConverters.add(new MappingJackson2HttpMessageConverter());
            adapter.setMessageConverters(messageConverters);
            return adapter;
        }

        @RestController
        static class MyController {
            @GetMapping("hello2")
            public Map<String,Object> hello() {
                Map<String,Object> map = new HashMap<>();
                map.put("hello2", "hello2, spring!");
                return map;
            }
        }
    }
}
