package com.jdbc.springdemo.subassembly.a20;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Configuration
@ComponentScan
public class WebConfig {

    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory(){
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet(){
        return new DispatcherServlet();
    }

    @Bean
    public DispatcherServletRegistrationBean dispatcherServletRegistrationBean(DispatcherServlet dispatcherServlet){
        return new DispatcherServletRegistrationBean(dispatcherServlet,"/");
    }

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping(){
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public MyRequestMappingHandlerAdapter myRequestMappingHandlerAdapter(){
        List<HandlerMethodArgumentResolver> argumentResolvers = new ArrayList<>();
        TokenArgumentResolver tokenArgumentResolver = new TokenArgumentResolver();
        argumentResolvers.add(tokenArgumentResolver);
        MyRequestMappingHandlerAdapter adapter = new MyRequestMappingHandlerAdapter();
        adapter.setCustomArgumentResolvers(argumentResolvers);

        List<HandlerMethodReturnValueHandler> returnValueHandlers = new ArrayList<>();
        YmlReturnValueResolver ymlReturnValueResolver = new YmlReturnValueResolver();
        returnValueHandlers.add(ymlReturnValueResolver);
        adapter.setCustomReturnValueHandlers(returnValueHandlers);

        return adapter;
    }

}
