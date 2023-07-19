package com.jdbc.springdemo.subassembly.a21;

import com.alibaba.druid.sql.visitor.functions.Char;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.function.HandlerFunction;
import org.springframework.web.servlet.function.RequestPredicate;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.support.HandlerFunctionAdapter;
import org.springframework.web.servlet.function.support.RouterFunctionMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.resource.*;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class UserController {

    @InitBinder

    public void test(int b, Char c, String a){
        MappingJackson2MessageConverter messageConverter;
        MappingJackson2XmlHttpMessageConverter xmlHttpMessageConverter;
        ResourceHttpRequestHandler handler = new ResourceHttpRequestHandler();
        List<ResourceResolver> resourceResolvers = new ArrayList<>();
        resourceResolvers.add(new CachingResourceResolver(new ConcurrentMapCache("static/")));
        resourceResolvers.add(new EncodedResourceResolver());
        resourceResolvers.add(new PathResourceResolver());
        handler.setResourceResolvers(resourceResolvers);
        
    }
}
