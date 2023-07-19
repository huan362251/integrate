package org.springframework.aop.framework.autoproxy;

import com.jdbc.springdemo.subassembly.a14.Target;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.*;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class A17 {

    public static void main(String[] args) throws NoSuchMethodException {
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
        proxyFactory.addAdvisors(list);
        List<Object> foo = proxyFactory.getInterceptorsAndDynamicInterceptionAdvice(Target1.class.getMethod("foo"), Target1.class);
        for (Object o : foo) {
            System.out.println(o);
        }
        //Object proxy, @Nullable Object target, Method method, @Nullable Object[] arguments,
        //			@Nullable Class<?> targetClass, List<Object> interceptorsAndDynamicMethodMatchers
//        ReflectiveMethodInvocation foo1 = new ReflectiveMethodInvocation(null,
//                target1,
//                Target1.class.getMethod("foo"),
//                new Object[0],
//                Target1.class,
//                foo);


    }

    static void test() {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("config", Config.class);
        context.registerBean("aspect1", Aspect1.class);
        context.registerBean(ConfigurationClassPostProcessor.class);

        context.registerBean(AnnotationAwareAspectJAutoProxyCreator.class);

        context.refresh();
//        String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }

        AnnotationAwareAspectJAutoProxyCreator creator = context.getBean(AnnotationAwareAspectJAutoProxyCreator.class);
        //理论上是三个
        List<Advisor> advisors = creator.findEligibleAdvisors(Target1.class, "target1");
//        for (Advisor advisor : advisors) {
//            System.out.println(advisor);
//        }
        Object o1 = creator.wrapIfNecessary(new Target1(), "target1", "target1");
        System.out.println(o1.getClass());
        ((Target1) o1).foo();
        Object o2 = creator.wrapIfNecessary(new Target2(), "target2", "target2");
        System.out.println(o2.getClass());
    }

    static class Target1 {
        public void foo() {
            System.out.println("foo");
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
            System.out.println("Aspect1 before foo ...");
        }

        @After("execution(* foo())")
        public void after() {
            System.out.println("Aspect1 after foo ...");
        }

        @Around("execution(* foo())")
        public void around() {
            System.out.println("Aspect1 after foo ...");
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
