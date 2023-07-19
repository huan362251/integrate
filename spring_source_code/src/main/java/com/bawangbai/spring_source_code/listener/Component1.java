package com.bawangbai.spring_source_code.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class Component1 {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void register(){
        publisher.publishEvent(new UserRegisteredEvent(this));
    }

}
