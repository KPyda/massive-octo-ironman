package com.testspring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Executor;

public class App {
    public static void main(String[] args) {
        String SQL = "CREATE TABLE Student( " +
                "ID   INT NOT NULL AUTO_INCREMENT, " +
                "NAME VARCHAR(20) NOT NULL, " +
                "AGE  INT NOT NULL, " +
                "PRIMARY KEY (ID));";

        Executor jdbcTemplateObject = null;
        jdbcTemplateObject.execute(SQL);
    }
}