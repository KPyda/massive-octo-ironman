package com.testspring.app;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * Created by Praktykant on 02.09.14.
 */
public class OuterBean implements ApplicationListener<ContextStoppedEvent> {
    private InnerBean innerBean;

    public OuterBean () {
        System.out.println("OuterBean: default constructor");
    }

    public void init() {
        System.out.println("OuterBean: initialization logic");
    }

    public void cleanup() {
        System.out.println("OuterBean: destruction logic");
    }

    public OuterBean(InnerBean innerBean) {
        System.out.println("OuterBean: parametrised constructor");
        this.innerBean = innerBean;
    }

    public InnerBean getInnerBean() {
        System.out.println("OuterBean: getter");
        return innerBean;
    }

    public void setInnerBean(InnerBean innerBean) {
        System.out.println("OuterBean: setter");
        this.innerBean = innerBean;
    }

    @Override
    public void onApplicationEvent(ContextStoppedEvent contextStoppedEvent) {
        System.out.println("OuterBean: onApplicationEvent(" + contextStoppedEvent.toString() + ")");
    }
}
