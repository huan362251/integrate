package com.jdbc.springdemo.subassembly.a04;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.lang.reflect.Proxy;

@Slf4j
@Scope(value = "pro",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Bean1 {

    private Bean2 bean2;

    @Autowired
    private void setBean2(Bean2 bean2) {
        log.info("@Autowired生效：{}",bean2);
        this.bean2 = bean2;
    }

    private Bean3 bean3;

    @Resource
    private void setBean3(Bean3 bean3){
        log.info("@Resource生效：{}",bean3);
        this.bean3 = bean3;
    }

    private String home;

    @Autowired
    private void setHome(@Value("${Path}") String home){
        log.info("@Value生效：{}",home);
        this.home = home;
    }

    @PostConstruct
    public void init(){
        log.info("@PostConstruct生效");
    }

    @PreDestroy
    public void destroy(){
        log.info("@PreDestroy生效");
    }

    @Override
    public String toString() {
        return "Bean1{" +
                "bean2=" + bean2 +
                ", bean3=" + bean3 +
                ", home='" + home + '\'' +
                '}';
    }
}
