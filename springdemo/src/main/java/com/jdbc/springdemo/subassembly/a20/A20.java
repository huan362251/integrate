package com.jdbc.springdemo.subassembly.a20;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class A20 {

    public static void main(String[] args) throws Exception {
        AnnotationConfigServletWebServerApplicationContext context
                = new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);
        //解析@RequestMapping以及派生注解，并且将生成方法与处理方法的映射
        RequestMappingHandlerMapping handlerMapping = context.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();
        handlerMethods.forEach((key,value)->{
            System.out.println(key + "=" + value);
        });
//        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest("GET", "/test1");
//        mockHttpServletRequest.setParameter("name","张三");
//        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
//        HandlerExecutionChain chain = handlerMapping.getHandler(mockHttpServletRequest);
//
//        System.out.println(chain);
        //通过子类公开保护的方法
        MyRequestMappingHandlerAdapter myRequestMappingHandlerAdapter = context.getBean(MyRequestMappingHandlerAdapter.class);
//        System.out.println(myRequestMappingHandlerAdapter);
//        myRequestMappingHandlerAdapter.invokeHandlerMethod(mockHttpServletRequest,mockHttpServletResponse, (HandlerMethod) chain.getHandler());
//
//        myRequestMappingHandlerAdapter.getArgumentResolvers();
//        myRequestMappingHandlerAdapter.getReturnValueHandlers();
//
//        MockHttpServletRequest mockHttpServletRequest1 = new MockHttpServletRequest("GET", "/test3");
//        mockHttpServletRequest1.addHeader("token","这是一个令牌");
//        MockHttpServletResponse mockHttpServletResponse1 = new MockHttpServletResponse();
//        HandlerExecutionChain chain1 = handlerMapping.getHandler(mockHttpServletRequest1);
//        myRequestMappingHandlerAdapter.invokeHandlerMethod(mockHttpServletRequest1,mockHttpServletResponse1, (HandlerMethod) chain1.getHandler());

        //请求url,必须要带/，否则就会匹配不到报错
        MockHttpServletRequest mockHttpServletRequest2 = new MockHttpServletRequest("GET", "/test4");
        MockHttpServletResponse mockHttpServletResponse2 = new MockHttpServletResponse();
        HandlerExecutionChain chain2 = handlerMapping.getHandler(mockHttpServletRequest2);
        System.out.println(myRequestMappingHandlerAdapter+"/"+mockHttpServletRequest2+"/"+mockHttpServletResponse2+"/"+chain2);
        myRequestMappingHandlerAdapter.invokeHandlerMethod(mockHttpServletRequest2,mockHttpServletResponse2, (HandlerMethod) chain2.getHandler());
        byte[] contentAsByteArray = mockHttpServletResponse2.getContentAsByteArray();
        System.out.println(new String(contentAsByteArray, StandardCharsets.UTF_8));



    }

}
