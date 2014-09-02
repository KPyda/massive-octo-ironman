package com.testspring.app;

import org.springframework.context.ApplicationListener;

/**
 * Created by Praktykant on 02.09.14.
 */
public class CustomEventHandler implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent customEvent) {
        System.out.println(customEvent.toString());
    }
}
