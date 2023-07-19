package com.bawangbai.spring_source_code.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Component3 {

    @EventListener
    public void listener(UserRegisteredEvent event) {
        System.out.println("component3:" + event.getSource());
    }

}
