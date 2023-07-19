package com.jdbc.springdemo.subassembly.a06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@Slf4j
public class MyBean implements BeanNameAware, ApplicationContextAware, InitializingBean {

    @Override
    public void setBeanName(String name) {
        log.info("当前bean" + this + ",名字叫：" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("当前bean" + this + ",容器是：" + applicationContext);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("当前bean" + this + "初始化");
    }

    @Autowired
    public void aaa(){
        log.info("@Autowired方法注入");
    }

    @PostConstruct
    public void pre(){
        log.info("@PostConstruct方法初始化");
    }

}
