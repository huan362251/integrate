package com.jdbc.springdemo.subassembly.a45;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.jdbc.springdemo.subassembly.a45.Bean1.*(..))")
    public void before(){
        System.out.println("before");
    }

}
