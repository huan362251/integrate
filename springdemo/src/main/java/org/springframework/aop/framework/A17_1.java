package org.springframework.aop.framework;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.*;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.interceptor.ExposeInvocationInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class A17_1 {

    public static void main(String[] args) throws Throwable {
        AspectInstanceFactory factory = new SingletonAspectInstanceFactory(new Aspect1());
        List<Advisor> list = new ArrayList<>();
        Method[] declaredMethods = Aspect1.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Before.class)) {
                //解析切点
                String value = declaredMethod.getAnnotation(Before.class).value();
                AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
                pointcut.setExpression(value);
                //通知类
                AspectJMethodBeforeAdvice advice = new AspectJMethodBeforeAdvice(declaredMethod, pointcut, factory);
                //切面
                DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(pointcut, advice);
                list.add(defaultPointcutAdvisor);
            } else if (declaredMethod.isAnnotationPresent(After.class)) {
                //解析切点
                String value = declaredMethod.getAnnotation(After.class).value();
                AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
                pointcut.setExpression(value);
                //通知类
                AspectJAfterAdvice advice = new AspectJAfterAdvice(declaredMethod, pointcut, factory);
                //切面
                DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(pointcut, advice);
                list.add(defaultPointcutAdvisor);
            } else if (declaredMethod.isAnnotationPresent(Around.class)) {
                //解析切点
                String value = declaredMethod.getAnnotation(Around.class).value();
                AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
                pointcut.setExpression(value);
                //通知类
                AspectJAroundAdvice advice = new AspectJAroundAdvice(declaredMethod, pointcut, factory);
                //切面
                DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(pointcut, advice);
                list.add(defaultPointcutAdvisor);
            }
        }
        for (Advisor advisor : list) {
            System.out.println(advisor);
        }

        //把切面换成环绕
        Target1 target1 = new Target1();
        System.out.println("》》》》》》》》》》》》》》》》》》》》》》");
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target1);
        proxyFactory.addAdvice(ExposeInvocationInterceptor.INSTANCE);
        proxyFactory.addAdvisors(list);
        List<Object> foo = proxyFactory.getInterceptorsAndDynamicInterceptionAdvice(Target1.class.getMethod("foo"), Target1.class);
        for (Object o : foo) {
            System.out.println(o);
        }
        //Object proxy, @Nullable Object target, Method method, @Nullable Object[] arguments,
        //			@Nullable Class<?> targetClass, List<Object> interceptorsAndDynamicMethodMatchers
        System.out.println("》》》》》》》》》》》》》》》》》》》》》》");
        ReflectiveMethodInvocation foo1 = new ReflectiveMethodInvocation(null,
                target1,
                Target1.class.getMethod("foo"),
                new Object[0],
                Target1.class,
                foo);
        foo1.proceed();

    }

    static class Target1 {
        public void foo() {
            System.out.println("this method foo");
        }
    }

    static class Target2 {
        public void bar() {
            System.out.println("bar");
        }
    }

    @Aspect
    static class Aspect1 {

        @Before("execution(* foo())")
        public void before() {
            System.out.println("Aspect1 before foo ...");
        }

        @Before("execution(* foo())")
        public void before1() {
            System.out.println("Aspect1 before1 foo ...");
        }

        @After("execution(* foo())")
        public void after() {
            System.out.println("Aspect1 after foo ...");
        }

        @Around("execution(* foo())")
        public void around() {
            System.out.println("Aspect1 around foo ...");
        }

    }

    @Configuration
    static class Config {

        @Bean
        public Advisor advisor(MethodInterceptor advice) {
            AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
            pointcut.setExpression("execution(* foo())");
            return new DefaultPointcutAdvisor(pointcut, advice);
        }

        @Bean
        public MethodInterceptor advice() {
            MethodInterceptor methodInterceptor = new MethodInterceptor() {
                @Override
                public Object invoke(MethodInvocation invocation) throws Throwable {
                    System.out.println("advice before...");
                    Object proceed = invocation.proceed();
                    System.out.println("advice after ...");
                    return proceed;
                }
            };
            return methodInterceptor;
        }

    }

}
