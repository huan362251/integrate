package com.bawangbai.spring_source_code.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Component2 {

    @EventListener
    public void listener(UserRegisteredEvent event) {
        System.out.println("component2:" + event.getSource());
    }

}
