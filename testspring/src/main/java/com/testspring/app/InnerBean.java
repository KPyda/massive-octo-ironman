package com.testspring.app;

import javafx.application.Application;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * Created by Praktykant on 02.09.14.
 */
public class InnerBean implements ApplicationListener<ContextStoppedEvent> {
    private String message;

    public InnerBean() {
        System.out.println("InnerBean: default constructor");
    }

    public InnerBean(String message) {
        System.out.println("InnerBean: parametrised constructor");
        this.message = message;
    }

    public void init() {
        System.out.println("InnerBean: initialization logic");
    }

    public void cleanup() {
        System.out.println("InnerBean: destruction logic");
    }

    public String getMessage() {
        System.out.println("InnerBean: getter");
        return message;
    }

    public void setMessage(String message) {
        System.out.println("InnerBean: setter");
        this.message = message;
    }

    @Override
    public void onApplicationEvent(ContextStoppedEvent contextStoppedEvent) {
        System.out.println("InnerBean: onApplicationEvent(" + contextStoppedEvent.toString() + ")");
    }
}
