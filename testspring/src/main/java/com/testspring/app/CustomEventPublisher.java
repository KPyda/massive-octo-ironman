package com.testspring.app;

import javafx.application.Application;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

/**
 * Created by Praktykant on 02.09.14.
 */
public class CustomEventPublisher implements ApplicationEventPublisher {
    private ApplicationEventPublisher publisher;

    public CustomEventPublisher() {}

    public CustomEventPublisher(ApplicationEventPublisher publisher) {
        setPublisher(publisher);
    }

    @Override
    public void publishEvent(ApplicationEvent applicationEvent) {
        System.out.println("Event: " + applicationEvent);
    }

    public ApplicationEventPublisher getPublisher() {
        return publisher;
    }

    public void setPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish() {
        CustomEvent customEvent = new CustomEvent(this);
        if (publisher != null)
            publisher.publishEvent(customEvent);
    }
}
