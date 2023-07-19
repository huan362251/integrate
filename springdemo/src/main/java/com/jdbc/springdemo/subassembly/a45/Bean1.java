package com.jdbc.springdemo.subassembly.a45;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bean1 {

    protected Bean2 bean2;

    protected boolean initialized;

    @Autowired
    public void setBean2(Bean2 bean2) {
        System.out.println("setBean2");
        this.bean2 = bean2;
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
        initialized = true;
    }

    public Bean2 getBean2() {
        System.out.println("getBean2");
        return bean2;
    }


}
