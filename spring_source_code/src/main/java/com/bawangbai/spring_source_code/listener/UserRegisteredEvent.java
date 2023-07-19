package com.bawangbai.spring_source_code.listener;

import org.springframework.context.ApplicationEvent;

public class UserRegisteredEvent extends ApplicationEvent {

    public UserRegisteredEvent(Object source) {
        super(source);
    }

}
