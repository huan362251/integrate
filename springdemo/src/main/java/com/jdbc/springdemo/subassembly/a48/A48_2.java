package com.jdbc.springdemo.subassembly.a48;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import sun.nio.ch.ThreadPool;

@Slf4j
@Configuration
public class A48_2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(A48_2.class);
        annotationConfigApplicationContext.getBean(MyService.class).doBusiness();
        annotationConfigApplicationContext.close();
    }

    @Component
    static class MyService {
        @Autowired
        private ApplicationEventPublisher applicationEventPublisher;

        public void doBusiness(){
            log.info("执行业务");
            applicationEventPublisher.publishEvent(new MyEvent("MyService doBusiness"));
        }


    }

    static class MyEvent extends ApplicationEvent {

        public MyEvent(Object source) {
            super(source);
        }
    }

    @Component
    static class SmsService {

        @EventListener
        public void listener(MyEvent myEvent){
            log.info("发短信");
        }
    }
    @Component
    static class EmailService{

        @EventListener
        public void listener(MyEvent myEvent){
            log.info("发邮件");
        }
    }

    @Bean
    public ThreadPoolTaskExecutor executor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(20);
        return executor;
    }

    @Bean
    public SimpleApplicationEventMulticaster applicationEventMulticaster(ThreadPoolTaskExecutor executor){
        SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        multicaster.setTaskExecutor(executor);
        return multicaster;
    }

}
