package com.jdbc.springdemo.subassembly.a15;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

public class A15 {

    public static void main(String[] args) {
        //准备好切点
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* foo())");
        //准备好通知
        MethodInterceptor interceptor = invocation -> {
            System.out.println("before...");
            Object result = invocation.proceed();
            System.out.println("after...");
            return result;
        };
        //准备切面
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, interceptor);
        //进行测试调用
        ProxyFactory proxyFactory = new ProxyFactory();
        Target target = new Target();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);
        Target proxy = (Target) proxyFactory.getProxy();
        proxy.foo();
        proxy.bar();

        StaticMethodMatcherPointcut matcherPointcut = new StaticMethodMatcherPointcut() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                MergedAnnotations from = MergedAnnotations.from(method, MergedAnnotations.SearchStrategy.TYPE_HIERARCHY);
                from.isPresent(Transactional.class);
                return false;
            }
        };
    }

    interface I1 {
        void foo();

        void bar();
    }

    static class Target implements  I1 {
        @Override
        public void foo() {
            System.out.println("调用 foo 方法");
        }

        @Override
        public void bar() {
            System.out.println("调用 bar 方法");
        }
    }
}
