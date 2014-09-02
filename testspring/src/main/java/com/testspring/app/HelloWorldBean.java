package com.testspring.app;

/**
 * Created by Praktykant on 02.09.14.
 */
public class HelloWorldBean {
    private String message;

    public HelloWorldBean() {
        System.out.println("Using default constructor");
    }

    public HelloWorldBean(String message) {
        System.out.println("Using parametrised constructor");
        setMessage(message);
    }

    public void setMessage(String message) {
        System.out.println("Using setter");
        this.message = message;
    }

    public String getMessage() {
        System.out.println("Using getter");
        return message;
    }
}
