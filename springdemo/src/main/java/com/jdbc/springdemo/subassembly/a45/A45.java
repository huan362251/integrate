package com.jdbc.springdemo.subassembly.a45;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class A45 {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(A45.class, args);
        Bean1 bean = context.getBean(Bean1.class);
        System.out.println(bean);
        showProxyAndTarget(bean);
        context.close();
    }

    public static void showProxyAndTarget(Bean1 proxy) throws Exception {
        System.out.println(">>>>> 代理中的成员变量");
        System.out.println("\tinitialized=" + proxy.initialized);
        System.out.println("\tbean2=" + proxy.bean2);

        if (proxy instanceof Advised) {
            Advised advised = (Advised) proxy;
            System.out.println(">>>>> 目标中的成员变量");
            Bean1 target = (Bean1) advised.getTargetSource().getTarget();
            System.out.println("\tinitialized=" + target.initialized);
            System.out.println("\tbean2=" + target.bean2);
        }
    }


}
