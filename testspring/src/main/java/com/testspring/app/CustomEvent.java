package com.testspring.app;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Praktykant on 02.09.14.
 */
public class CustomEvent extends ApplicationEvent {
    public CustomEvent(Object source) {
        super(source);
    }
}
